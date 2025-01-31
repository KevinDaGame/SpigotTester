/*
 * MIT License
 *
 * Copyright (c)  $originalComment.match("Copyright \(c\) (\d+)", 1, "-", "$today.year")2023. jwdeveloper
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

package io.github.jwdeveloper.spigot.tester.api.assertions;

import io.github.jwdeveloper.spigot.tester.api.exception.AssertionException;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerAssertions
{
    private final Player player;

    public PlayerAssertions(Player player)
    {
        this.player = player;
    }

    public PlayerAssertions hasName(String name)
    {
        getAssertion(player.getName()).shouldBe(name);
        return this;
    }

    public PlayerAssertions hasPassenger()
    {
        return this;
    }

    public PlayerAssertions hasOp()
    {
        return this;
    }

    public PlayerAssertions hasLocation(Location location)
    {
        return this;
    }

    public PlayerAssertions hasPermission(String ... permissions)
    {
        return this;
    }


    public PlayerAssertions hasItemStack(ItemStack itemStack)
    {
        return this;
    }

    public PlayerAssertions hasPassenger(Entity ... entities)
    {
        return this;
    }


    private Assertions getAssertion(Object target)
    {
        return new Assertions(target);
    }
}


