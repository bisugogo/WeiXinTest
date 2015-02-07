package com.wecharttest.message;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wecharttest.util.Constants;

public class ReturnTextMessage extends ReturnBaseMessage {

	private String msgContent;

	  private Document doc;
	  
	  public ReturnTextMessage(Document doc){
	    this.doc = doc;
	    this.setMsgType(Constants.TEXT);
	  }
	  
	  public ReturnTextMessage(){
	    this.setMsgType(Constants.TEXT);
	  }
	  
	  public String getMsgContent() {
	    return msgContent;
	  }

	  public void setMsgContent(String msgContent) {
	    this.msgContent = msgContent;
	  }

	  @Override
	  public ReturnBaseMessage parseMessage() {
	    Element root = doc.getRootElement();  
	    
	    List<Element> list = root.getChildren();  
	    for(int j=0;j<list.size();j++){  
	        Element first = (Element) list.get(j);  
	        if(first.getName().equalsIgnoreCase("ToUserName")){  
	            this.setToUser(first.getValue().trim());  
	        }else if(first.getName().equalsIgnoreCase("FromUserName")){  
	            this.setFromUser(first.getValue().trim());  
	        }else if(first.getName().equalsIgnoreCase("Content")){  
	            this.setMsgContent(first.getValue().trim());  
	        }else if(first.getName().equalsIgnoreCase("CreateTime")){  
	            this.setCreateTime(Long.parseLong(first.getValue().trim()));  
	        }
	    }  
	    return this;    
	  }
	
}
