package canitzp.AdvancedLib.util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandMaker extends CommandBase {

    public String name;
    public String[] array;
    public CommandMaker(String name, String[] array){
        this.name = name;
        this.array = array;
    }
    @Override
    public String getCommandName() {
        return this.name;
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "commands." + this.name + ".usage";
    }

    @Override
    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
        array.clone();
    }
}
