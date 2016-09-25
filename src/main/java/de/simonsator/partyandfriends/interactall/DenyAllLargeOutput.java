package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.main.Main;

/**
 * @author Simonsator
 * @version 1.0.0 25.09.16
 */
public class DenyAllLargeOutput extends InteractAllCommand {
	public DenyAllLargeOutput(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	protected void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester) {
		Main.getInstance().getFriendsCommand().execute(pPlayer.getPlayer(),
				new String[]{"friend",
						IAMain.getInstance().getConfig().getString("DenyAll.LargeOutput.DenyCommandName", pRequester.getName())});
	}

}
