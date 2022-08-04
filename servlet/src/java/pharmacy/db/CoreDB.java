/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharmacy.db;

import com.pharmacy.model.UserModel;
import java.util.LinkedHashMap;

/**
 *
 * @author janvier
 */
public class CoreDB {
    private LinkedHashMap<Integer, UserModel> records = new LinkedHashMap<Integer, UserModel>();
	private static final CoreDB instance = new CoreDB();
	private CoreDB() {
		
	}
	public static CoreDB getInstance() {
		return instance;
	}
	public LinkedHashMap<Integer, UserModel> getData() {
		return records;
	}
    
}
