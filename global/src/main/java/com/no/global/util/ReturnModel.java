package com.no.global.util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReturnModel {
	public static final int YES = 1;
	public static final int NO = 0;
	private JSONObject jsonObject = new JSONObject();

	public ReturnModel() {
		this.jsonObject.put("code", 1);
	}

	public ReturnModel(int code) {
		this.jsonObject.put("code", Integer.valueOf(code));
	}

	public ReturnModel(int code, String message) {
		this.jsonObject.put("code", Integer.valueOf(code));
		this.jsonObject.put("message", message);
	}

	public ReturnModel(Object data) {
		this.jsonObject.put("code", Integer.valueOf(1));
		this.jsonObject.put("data", data);
	}

	public ReturnModel(String info, String status) {
		this.jsonObject.put("info", info);
		this.jsonObject.put("status", status);
	}

	public ReturnModel(int code, Object data) {
		this.jsonObject.put("code", Integer.valueOf(code));
		this.jsonObject.put("data", data);
	}

	public ReturnModel(boolean isTrue) {
		this.jsonObject.put("code", Integer.valueOf(isTrue ? 1 : 0));
	}

	public int getCode() {
		return this.jsonObject.getInt("code");
	}

	public void setCode(int code) {
		this.jsonObject.put("code", Integer.valueOf(code));
	}

	public String getMessage() {
		return this.jsonObject.getString("message");
	}

	public void setMessage(String message) {
		this.jsonObject.put("message", message);
	}

	public String getData() {
		return this.jsonObject.getString("data");
	}

	public void setData(Object data) {
		this.jsonObject.put("data", data);
	}

	public void renderJSON(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		PrintWriter out = response.getWriter();
		out.println(this);
	}

	public String toString() {
		return this.jsonObject != null ? this.jsonObject.toString() : "{}";
	}
}