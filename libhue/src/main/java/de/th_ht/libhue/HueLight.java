/*
 * Ambilike produces an Ambilight like effect using the Philips Hue system and a rooted Android
 * device
 * Copyright (C) 2015  Thomas Hartmann <thomas.hartmann@th-ht.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.th_ht.libhue;


public class HueLight extends HueLightObject
{
  private final int id;
  HueRestInterface.LightState state;

  HueLight(HueRestInterface.LightState state, int id)
  {
    super();
    this.state = state;
    this.id = id;
  }

  @Override
  public void postUpdate()
  {
    postUpdate(true);
  }

  public void postUpdate(boolean doUpdate)
  {
    bridge.postUpdate(id, curUpdate, doUpdate);
  }


  public boolean isOn()
  {
    return state.state.on;
  }

  public String getName()
  {
    return state.name;
  }

  void setUpdate(HueRestInterface.LightUpdate update)
  {
    this.curUpdate = update;
  }
}
