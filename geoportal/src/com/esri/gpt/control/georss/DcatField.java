/* See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * Esri Inc. licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.gpt.control.georss;

import java.util.ArrayList;
import java.util.List;

/**
 * Dcat field mapped object
 */
public class DcatField {
    private static final String DEFAULT_JOINOPERATOR = ", ";
	private String name = "";
	private List<List<String>> index= new ArrayList<List<String>>();
	private String type = "string";
	private String dateFormat = "";
	private String delimiter = "";
	private int maxChars = -1;
	private boolean required;
    private final DcatDomain domain = new DcatDomain();
    private final DcatDomain media = new DcatDomain();
    private String joinOperator = DEFAULT_JOINOPERATOR;

    public String getJoinOperator() {
      return joinOperator;
    }

    public void setJoinOperator(String joinOperator) {
      this.joinOperator = joinOperator!=null? joinOperator: DEFAULT_JOINOPERATOR;
    }

    public void addMapping(String from, String value) {
      domain.addMapping(from, value);
    }
    
    public void addMedia(String urlPattern, String value) {
      media.addMapping(urlPattern, value);
    }

    public String translate(String value) {
      return domain.translate(value);
    }
    
    public String guessMedia(String value) {
      return media.translate(value, "application/octet-stream");
    }
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String getType() {
		return type;
	}
		
	public void setType(String type) {
		if(type != null && type.length() > 0){
			this.type = type;
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name != null && name.length() >0){
			this.name = name;
		}
	}
	/**
	 * @return the index
	 */
	public List<List<String>> getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(List<List<String>> index) {
		this.index = index!=null? index: new ArrayList<List<String>>();
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	public int getMaxChars() {
		return maxChars;
	}
	public void setMaxChars(int maxChars) {
		this.maxChars = maxChars;
	}	
	
}
