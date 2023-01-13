/*
 * MIT License
 *
 * Copyright (c)  2023. jwdeveloper
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package jw.spigot.tests;

import jw.spigot.MyPlugin;
import jw.spigot.tester.api.SpigotTest;
import jw.spigot.tester.api.annotations.Test;
import jw.spigot.tester.api.assertions.SpigotAssertion;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ServerTest implements SpigotTest {
    private final MyPlugin plugin;

    public ServerTest(MyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void beforeAll() {
        if (Bukkit.getPlayer("mike") == null) {
            throw new RuntimeException("Players are required for this test");
        }
    }

    @Test(name = "Give player Diamond")
    public void playerShouldRecieveItem() {
        //arrange
        var player = Bukkit.getPlayer("mike");
        var item = new ItemStack(Material.DIAMOND,1);

        //act
        player.getInventory().setItemInOffHand(item);

        //assert
        SpigotAssertion.shouldBeEqual(Material.DIAMOND, player.getInventory().getItemInMainHand().getType());
        SpigotAssertion.shouldBeEqual(1, player.getInventory().getItemInMainHand().getAmount());
    }


    @Test(ignore = true)
    public void someThinkElse() {

    }
}
