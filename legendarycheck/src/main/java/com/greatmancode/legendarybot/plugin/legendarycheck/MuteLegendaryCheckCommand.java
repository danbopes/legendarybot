/*
 * MIT License
 *
 * Copyright (c) Copyright (c) 2017-2017, Greatmancode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.greatmancode.legendarybot.plugin.legendarycheck;

import com.greatmancode.legendarybot.api.commands.AdminCommand;
import com.greatmancode.legendarybot.api.commands.ZeroArgsCommand;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * The !mutelc command.
 */
public class MuteLegendaryCheckCommand extends AdminCommand implements ZeroArgsCommand {

    /**
     * An instance of the Legendary Check plugin
     */
    private LegendaryCheckPlugin plugin;

    public MuteLegendaryCheckCommand(LegendaryCheckPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        plugin.stopLegendaryCheck(event.getGuild());
        event.getChannel().sendMessage(plugin.getBot().getTranslateManager().translate(event.getGuild(), "command.mutelegendarycheck.message")).queue();
    }

    @Override
    public String help(Guild guild) {
        return plugin.getBot().getTranslateManager().translate(guild, "command.mutelegendarycheck.longhelp");
    }

    @Override
    public String shortDescription(Guild guild) {
        return plugin.getBot().getTranslateManager().translate(guild, "command.mutelegendarycheck.shorthelp");
    }
}
