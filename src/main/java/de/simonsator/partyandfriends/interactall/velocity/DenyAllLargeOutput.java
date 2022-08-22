package de.simonsator.partyandfriends.interactall.velocity;

import de.simonsator.partyandfriends.velocity.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.velocity.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.velocity.friends.commands.Friends;

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
