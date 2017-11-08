package com.zhangqii.pojo;

/**
 * 装饰类，为title类增加关联标签的详细内容
 * @author Jone
 *
 */
public class TitleAndTag extends TTitle {
	
	private TTag tag;
	public void setTag(TTag tag) {
		this.tag = tag;
	}
	public TTag getTag() {
		return tag;
	}
}
