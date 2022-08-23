package de.simonsator.partyandfriends.velocity.interactall;

import de.simonsator.partyandfriends.velocity.api.friends.abstractcommands.FriendSubCommand;
import de.simonsator.partyandfriends.velocity.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.velocity.api.pafplayers.PAFPlayer;
import net.kyori.adventure.text.Component;

import java.util.List;

public abstract class InteractAllCommand extends FriendSubCommand {
	public InteractAllCommand(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	protected boolean hasFriendRequests(OnlinePAFPlayer pPlayer) {
		List<PAFPlayer> requests = pPlayer.getRequests();
		if (requests.isEmpty()) {
			pPlayer.sendMessage(Component.text(PREFIX +
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
