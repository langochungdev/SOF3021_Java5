package web.service;

import java.net.http.HttpRequest;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamS {

	@Autowired
	HttpServletRequest request;

	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		return (value != null) ? value : defaultValue;
	}
	
	public int getInt(String name, int defaultValue) {
		String value = request.getParameter(name);
		try {
			return (value != null) ? Integer.parseInt(value) : defaultValue;
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	public double getDouble(String name, double defaultValue) {
		String value = request.getParameter(name);
		try {
			return (value != null) ? Double.parseDouble(value) : defaultValue;
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	public boolean getBoolean(String name, boolean defaultValue) {
		String value = request.getParameter(name);
		return (value != null) ? Boolean.parseBoolean(value) : defaultValue;
	}
	
	public Date getDate(String name, String pattern) {
		String value = request.getParameter(name);
		return null;
	}
	
	public File getFile(String name, String path) {
		return null;
	}
	
}
