package de.simonsator.partyandfriends.velocity.interactall;

import de.simonsator.partyandfriends.velocity.api.adapter.BukkitBungeeAdapter;
import de.simonsator.partyandfriends.velocity.api.events.command.FriendshipCommandEvent;
import de.simonsator.partyandfriends.velocity.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.velocity.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.velocity.friends.commands.Friends;
import de.simonsator.partyandfriends.velocity.friends.subcommands.Add;
import net.kyori.adventure.text.Component;

public class AcceptAllSmallOutput extends InteractAllCommand {
	public AcceptAllSmallOutput(String[] pCommands, int pPriority, String pHelp) {
		super(pCommands, pPriority, pHelp);
	}

	@Override
	protected void execute(OnlinePAFPlayer pPlayer, PAFPlayer pRequester) {
		FriendshipCommandEvent event = new FriendshipCommandEvent(pPlayer, pRequester,
				new String[]{getCommandName(), pRequester.getName()}, Friends.getInstance().getSubCommand(Add.class));
		BukkitBungeeAdapter.getInstance().callEvent(event);
		if (event.isCancelled())
			return;
		pPlayer.addFriend(pRequester);
		pPlayer.denyRequest(pRequester);
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		if (!hasFriendRequests(pPlayer))
			return;
		pPlayer.sendMessage(PREFIX +
				IAMain.getInstance().getConfig().getString("Messages.AcceptAll.AcceptedAll"));
	}
}
