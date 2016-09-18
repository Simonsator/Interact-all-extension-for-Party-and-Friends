package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.main.Main;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.List;

/**
 * @author simonbrungs
 * @version 1.0.0 18.09.16
 */
public class DenyAll extends InteractAllCommand {
	protected DenyAll(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		List<PAFPlayer> requests = pPlayer.getRequests();
		if (!hasFriendRequests(pPlayer, requests))
			return;
		for (PAFPlayer player : requests)
			pPlayer.denyRequest(player);
		pPlayer.sendMessage(new TextComponent(Main.getInstance().getFriendsPrefix() +
				IAMain.getInstance().getConfig().getString("Messages.DenyAll.DeniedAll")));
	}
}
