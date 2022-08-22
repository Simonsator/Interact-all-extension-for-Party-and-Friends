package de.simonsator.partyandfriends.bungee.interactall;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.friends.commands.Friends;

public class DenyAllLargeOutput extends InteractAllCommand {
	public DenyAllLargeOutput(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	protected void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester) {
		Friends.getInstance().execute(pPlayer.getPlayer(),
				new String[]{"friend",
						IAMain.getInstance().getConfig().getString("DenyAll.LargeOutput.DenyCommandName"), pRequester.getName()});
	}

}
