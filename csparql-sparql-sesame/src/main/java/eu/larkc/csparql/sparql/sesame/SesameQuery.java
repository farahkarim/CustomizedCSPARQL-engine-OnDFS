/**
 * Copyright 2011-2015 DEIB - Politecnico di Milano
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Acknowledgements:
 * We would like to thank Davide Barbieri, Emanuele Della Valle,
 * Marco Balduini, Soheila Dehghanzadeh, Shen Gao, and
 * Daniele Dell'Aglio for the effort in the development of the software.
 *
 * This work is partially supported by
 * - the European LarKC project (FP7-215535) of DEIB, Politecnico di
 * Milano
 * - the ERC grant “Search Computing” awarded to prof. Stefano Ceri
 * - the European ModaClouds project (FP7-ICT-2011-8-318484) of DEIB,
 * Politecnico di Milano
 * - the IBM Faculty Award 2013 grated to prof. Emanuele Della Valle;
 * - the City Data Fusion for Event Management 2013 project funded
 * by EIT Digital of DEIB, Politecnico di Milano
 * - the Dynamic and Distributed Information Systems Group of the
 * University of Zurich;
 * - INSIGHT NUIG and Science Foundation Ireland (SFI) under grant
 * No. SFI/12/RC/2289
 */
package eu.larkc.csparql.sparql.sesame;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import eu.larkc.csparql.sparql.api.SparqlQuery;

public class SesameQuery implements SparqlQuery {

   private final String id;
   private String command;

   
   public String getId() {
      // TODO implement SparqlQuery.getIdentifier
      return this.id;
   }

   
   public String getQueryCommand() {
      // TODO implement SparqlQuery.getQueryCommand
      return this.command;
   }

   public SesameQuery(final String cmd) {
      this();
      this.command = cmd;
   }

   public SesameQuery() {
      this.id = this.generateID();
   }

   private String generateID() {
      return UUID.randomUUID().toString();
   }

   
   public boolean isAskQuery() {
	   List<String> keywords = new ArrayList<String>(); 
	   keywords.add("ask");

	   for(String s: keywords)
		   if (command.toLowerCase().contains(s.toLowerCase()))
			   return true;
	   
	   return true;
   }

   
   public boolean isGraphQuery() {
	   
	   List<String> keywords = new ArrayList<String>(); 
	   keywords.add("construct");
	   keywords.add("describe");

	   for(String s: keywords)
		   if (command.toLowerCase().contains(s.toLowerCase()))
			   return true;
	   
	   return true;
   }

   
   public boolean isSelectQuery() {
	   List<String> keywords = new ArrayList<String>(); 
	   keywords.add("select");

	   for(String s: keywords)
		   if (command.toLowerCase().contains(s.toLowerCase()))
			   return true;
	   
	   return true;
   }
}
