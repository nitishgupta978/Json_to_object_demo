package com.sm.app.dtos;

import java.util.ArrayList;
/**
 * 
 * @author nitish.gupta_spicemo
 *
 */

public class PlanApiResponse {

	private String valRefId;
	private ArrayList<PlanResponse> planResponse;

	@Override
	public String toString() {
		return "PlanApiResponse [valRefId=" + valRefId + ", planResponse=" + planResponse + "]";
	}

	public String getValRefId() {
		return valRefId;
	}

	public void setValRefId(String valRefId) {
		this.valRefId = valRefId;
	}

	public ArrayList<PlanResponse> getPlanResponse() {
		return planResponse;
	}

	public void setPlanResponse(ArrayList<PlanResponse> planResponse) {
		this.planResponse = planResponse;
	}

	public static class PlanResponse {
		private String type;
		private ArrayList<PlanResponseParam> planResponseParams;

		@Override
		public String toString() {
			return "PlanResponse [type=" + type + ", planResponseParams=" + planResponseParams + "]";
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public ArrayList<PlanResponseParam> getPlanResponseParams() {
			return planResponseParams;
		}

		public void setPlanResponseParams(ArrayList<PlanResponseParam> planResponseParams) {
			this.planResponseParams = planResponseParams;
		}

	}

	public static class PlanResponseParam {
		private String name;
		private String value;

		@Override
		public String toString() {
			return "PlanResponseParam [name=" + name + ", value=" + value + "]";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
