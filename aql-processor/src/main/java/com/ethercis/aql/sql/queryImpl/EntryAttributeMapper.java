/*
 * Copyright (c) 2015 Christian Chevalley
 * This file is part of Project Ethercis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ethercis.aql.sql.queryImpl;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Map a datavalue UML expression from an ARCHETYPED structure into its RM/JSON representation
 * see http://www.openehr.org/releases/trunk/UML/ for field identification
 * Created by christian on 5/11/2016.
 */
public class EntryAttributeMapper {

    //from Locatable
    private static String toCamelCase(String underscoreSeparated) {
        if( ! underscoreSeparated.contains("_")) {
            return underscoreSeparated;
        }
        StringTokenizer tokens = new StringTokenizer(underscoreSeparated, "_");
        StringBuffer buf = new StringBuffer();
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();
            if (buf.length() == 0) {
                buf.append(word);
            } else {
                buf.append(word.substring(0, 1).toUpperCase());
                buf.append(word.substring(1));
            }
        }
        return buf.toString();
    }

    private static Integer firstOccurence(int offset, List<String> list, String match){
        for (int i = offset; i < list.size(); i++){
            if (list.get(i).equals(match))
                return i;
        }
        return null;
    }

    /**
     * do a simple toCamelCase translation... and prefix all with /value :-)
     * @param attribute
     * @return
     */
    public static String map(String attribute){
        List<String> fields = new ArrayList<>();

        fields.addAll(Arrays.asList(attribute.split("/")));
        fields.remove(0);

        int floor = 1;

        if (fields.size() < 1)
            return null; //this happens when a non specified value is queried f.e. the whole json body

        //deals with the tricky ones first...
        if (fields.get(0).equals("ism_transition")){
            //get the next key and concatenate...
            String subfield = fields.get(1);
            fields.remove(0);
            fields.set(0, "ism_transition/" + subfield);
            if (!fields.get(1).equals("name")){
                fields.add(1, "/value");
            }
            floor = 2;
        } else if (fields.get(0).equals("other_participations")){ //insert a tag value
            fields.set(0, "other_participations");
            fields.add(1, "0");
            fields.add(2, "/value");
            floor = 3;
        }
        else { //this deals with the "/value,value"
            Integer match = firstOccurence(0, fields, "value");
//            Integer match = fields.stream().filter(m -> m.equals("value"));
            if (match != null){ //deals with "/value/value"
                if (match == 0 && fields.size() == 2 && fields.get(1).equals("value")){
//                    fields.add(1, "/value");
                    ;
                }
                else if (match != 0) {
                    fields.set(match, "/value");
                    if (match == fields.size() - 1)
                        fields.add("value");
                }
                else if (match + 1 < fields.size() - 1){
                    Integer first = firstOccurence(match+1, fields, "value");
                    if ( first != null && first == match+1)
                        fields.set(match+1, "/value");
                }
            }
//            match = firstOccurence(0, fields, "name");
//            if (match != null) {
//                if (match < fields.size() - 1) {
//                    if (fields.get(match + 1).equals("name")) {
//                        fields.set(match + 1, "/name");
//                    }
//                }
//                else if (match+1 == fields.size()){
//                    //set it with a "/"
//                    fields.set(match, "/name");
//                }
//            }
        }

        //prefix the first element
        fields.set(0, "/"+fields.get(0));

        //deals with the remainder of the array
        for (int i = floor; i < fields.size(); i++){
            fields.set(i, toCamelCase(fields.get(i)));
        }

        //elegant...
        String encoded = StringUtils.join(fields, ",");

        return encoded;
    }
}
