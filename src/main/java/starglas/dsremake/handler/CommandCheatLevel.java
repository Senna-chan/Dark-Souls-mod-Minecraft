package starglas.dsremake.handler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import starglas.dsremake.common.helpers.ModHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Starlight on 8-9-2015.
 */
public class CommandCheatLevel extends CommandBase implements ICommand  {

    private List aliases;

    public CommandCheatLevel(){
        aliases = new ArrayList();
        aliases.add("DSChangeLevel");
        aliases.add("DSCL");
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public String getCommandName() {
        return "DSChangeLevel";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "DSChangeLevel <text> <text> <int>";
    }

    @Override
    public List getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        for(int i=0;i<args.length;i++){
            ModHelper.displayChat((EntityPlayer)sender, args[i]);
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return p_71516_2_.length == 1 ? getListOfStringsMatchingLastWord(p_71516_2_, new String[] {"survival", "creative", "adventure"}): (p_71516_2_.length == 2 ? getListOfStringsMatchingLastWord(p_71516_2_, this.getListOfPlayerUsernames()) : null);
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    protected String[] getListOfPlayerUsernames()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
