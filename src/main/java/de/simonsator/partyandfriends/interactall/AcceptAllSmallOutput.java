package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.main.Main;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.List;

/**
 * @author Simonsator
 * @version 1.0.0 18.09.16
 */
public class AcceptAllSmallOutput extends InteractAllCommand {
	public AcceptAllSmallOutput(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	protected void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester) {
		pPlayer.addFriend(pRequester);
		pPlayer.denyRequest(pRequester);
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		if (!hasFriendRequests(pPlayer))
			return;
		pPlayer.sendMessage(new TextComponent(PREFIX +
				IAMain.getInstance().getConfig().getString("Messages.AcceptAll.AcceptedAll")));
	}
}
