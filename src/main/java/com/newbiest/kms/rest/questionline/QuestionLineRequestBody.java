package com.newbiest.kms.rest.questionline;

import com.newbiest.kms.model.QuestionLine;
import com.newbiest.base.msg.RequestBody;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("具体请求操作信息")
public class QuestionLineRequestBody extends RequestBody {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "操作类型", example = "Create/Update等")
	private String actionType;

	@ApiModelProperty(value="问题主键")
	private String questionRrn;

	@ApiModelProperty(value = "操作的问题详情对象")
	private QuestionLine questionLine;

}
