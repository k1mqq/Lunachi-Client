package KeemaCurry.utils;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import KeemaCurry.Client;
import KeemaCurry.ui.StatesUI;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;

public class PlayerUtil {
	public static final Ordering ENTRY_ORDERING = Ordering.from(new PlayerComparator());
	public static List<NetworkPlayerInfo> playerList = ENTRY_ORDERING.<NetworkPlayerInfo>sortedCopy(Client.mc.player.connection.getPlayerInfoMap());
	public static ResourceLocation getSkinByName(String name) {
		for(int i = 0; i < playerList.size(); i++) {
			NetworkPlayerInfo player = playerList.get(i);
			if(player.getGameProfile().getName().equals(name)) {
				return player.getLocationSkin();
			}
		}
		
		return null;
	}
	
	public static class PlayerComparator implements Comparator<NetworkPlayerInfo>
    {
        private PlayerComparator()
        {
        }

        public int compare(NetworkPlayerInfo p_compare_1_, NetworkPlayerInfo p_compare_2_)
        {
            ScorePlayerTeam scoreplayerteam = p_compare_1_.getPlayerTeam();
            ScorePlayerTeam scoreplayerteam1 = p_compare_2_.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst(p_compare_1_.getGameType() != GameType.SPECTATOR, p_compare_2_.getGameType() != GameType.SPECTATOR).compare(scoreplayerteam != null ? scoreplayerteam.getRegisteredName() : "", scoreplayerteam1 != null ? scoreplayerteam1.getRegisteredName() : "").compare(p_compare_1_.getGameProfile().getName(), p_compare_2_.getGameProfile().getName()).result();
        }
    }
}
