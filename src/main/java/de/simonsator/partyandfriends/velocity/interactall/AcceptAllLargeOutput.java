package de.simonsator.partyandfriends.velocity.interactall;

import de.simonsator.partyandfriends.velocity.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.velocity.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.velocity.friends.commands.Friends;

public class AcceptAllLargeOutput extends InteractAllCommand {
	public AcceptAllLargeOutput(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	protected void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester) {
		Friends.getInstance().execute(pPlayer.getPlayer(),
				new String[]{"friend",
						IAMain.getInstance().getConfig().getString("AcceptAll.LargeOutput.AcceptCommandName"), pRequester.getName()});
	}

}
