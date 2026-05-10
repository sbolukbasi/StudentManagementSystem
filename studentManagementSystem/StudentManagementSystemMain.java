package studentManagementSystem;


public class StudentManagementSystemMain {

    public static void main(String[] args) {
        OnlineDB.connectOnlineDB();
        
        Table tables = new Table();
        tables.CreateTables();
        //tables.InsertSampleData();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });

    }
    
}
