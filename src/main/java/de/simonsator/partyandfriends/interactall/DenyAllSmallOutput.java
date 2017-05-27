package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * @author Simonsator
 * @version 1.0.0 18.09.16
 */
public class DenyAllSmallOutput extends InteractAllCommand {
	protected DenyAllSmallOutput(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	protected void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester) {
		pPlayer.denyRequest(pRequester);
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		if (!hasFriendRequests(pPlayer))
			return;
		pPlayer.sendMessage(new TextComponent(PREFIX +
				IAMain.getInstance().getConfig().getString("Messages.DenyAll.DeniedAll")));
	}
}
