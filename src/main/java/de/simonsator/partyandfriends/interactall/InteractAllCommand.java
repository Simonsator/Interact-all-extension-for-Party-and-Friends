package de.simonsator.partyandfriends.interactall;

import de.simonsator.partyandfriends.api.friends.abstractcommands.FriendSubCommand;
import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.main.Main;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.List;

/**
 * @author Simonsator
 * @version 1.0.0 18.09.16
 */
public abstract class InteractAllCommand extends FriendSubCommand {
	public InteractAllCommand(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	protected boolean hasFriendRequests(OnlinePAFPlayer pPlayer) {
		List<PAFPlayer> requests = pPlayer.getRequests();
		if (requests.isEmpty()) {
			pPlayer.sendMessage(new TextComponent(PREFIX +
					IAMain.getInstance().getConfig().getString("Messages.NoFriendRequests")));
			return false;
		}
		for (PAFPlayer player : requests)
			execute(pPlayer, player);
		return true;
	}

	protected abstract void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester);

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		if (!hasFriendRequests(pPlayer))
			return;
	}
}
