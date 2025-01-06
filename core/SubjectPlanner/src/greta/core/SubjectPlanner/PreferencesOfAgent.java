/*
 * This file is part of Greta.
 *
 * Greta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Greta.  If not, see <https://www.gnu.org/licenses/>.
 *
 */
package greta.core.SubjectPlanner;

import greta.core.util.parameter.EngineParameterSetOfSet;

/**
 *
 * @author Nadine
 */
public class PreferencesOfAgent extends EngineParameterSetOfSet{

    public static final String OBJECT_PREF_AGENT_LIB = "SubjectPlanner/Data/ObjectPreferenceAgent.xml";

    public static Sentences global_obj_pref_library;

    public PreferencesOfAgent(String fileName){
      super(fileName);
    }

}
