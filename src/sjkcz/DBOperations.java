package sjkcz;

public class DBOperations {
	public DBAccess db=new DBAccess();//封装了数据库操作的类
	String sql;
	public void DBoperations(String sql,int action){
		db.dbconn();
		switch(action) {
		case 0:
			db.dbSelect(sql);
			
			break;
		case 1:
			db.dbUpdate(sql);
			db.dbclose();
			break;
		case 2:
			db.dbInsert(sql);
			db.dbclose();
			break;
		case 3:
			db.dbDelete(sql);
			db.dbclose();
			break;
		}
	}
}
