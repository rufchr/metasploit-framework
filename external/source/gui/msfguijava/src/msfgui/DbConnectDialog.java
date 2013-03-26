package msfgui;

import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JTextField;

/**
 * Options dialog to get database connection options.
 * @author scriptjunkie
 */
public class DbConnectDialog extends OptionsDialog {
	private RpcConnection rpcConn;
	private Frame myParent;
	private boolean success;
	private Map props;

	//Opens dialog to get options
	public static boolean connect(Frame parent, RpcConnection rpcConn){
		DbConnectDialog cd = new DbConnectDialog(parent, rpcConn, true);
		try{
			if(cd.tryConnect())
				return true;
		} catch (MsfException mex) { // on error connecting, show dialog
		}
		cd.setVisible(true);
		return cd.success;
	}
	//Tries to connect without opening a dialog
	public static boolean tryConnect(Frame parent, RpcConnection rpcConn){
		DbConnectDialog cd = new DbConnectDialog(parent, rpcConn, true);
		try{
			return cd.tryConnect();
		} catch (MsfException mex) { // on error connecting, show dialog
		}
		return false;
	}
    /** Creates new form DbConnectDialog */
    public DbConnectDialog(Frame parent, RpcConnection rpcConn, boolean modal) {
        super(parent, "Database Connection Options", modal);
        initComponents();
		this.rpcConn = rpcConn;
		myParent = parent;
		success = false;
		props = MsfguiApp.getPropertiesNode();
		try{
			//If we don't have saved creds, look for them
			if(!props.containsKey("dbusername"))
				reloadDefaults();
			showDefaults();
		}catch(NullPointerException nex){
		}catch(MsfException mex){// No msf root?
			mex.printStackTrace();
		}
		Object driver = props.get("dbdriver");
		List l = ((javax.swing.SpinnerListModel)typeSpinner.getModel()).getList();
		for ( Object o : l )
			if(o.equals(driver))
				typeSpinner.setValue(driver);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dbNameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        hostField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        defaultsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        typeSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"postgresql", "mysql", "sqlite3"}));
        typeSpinner.setName("typeSpinner"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(msfgui.MsfguiApp.class).getContext().getResourceMap(DbConnectDialog.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        usernameField.setText(resourceMap.getString("usernameField.text")); // NOI18N
        usernameField.setName("usernameField"); // NOI18N

        passwordField.setText(resourceMap.getString("passwordField.text")); // NOI18N
        passwordField.setName("passwordField"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        dbNameField.setText(resourceMap.getString("dbNameField.text")); // NOI18N
        dbNameField.setName("dbNameField"); // NOI18N

        connectButton.setText(resourceMap.getString("connectButton.text")); // NOI18N
        connectButton.setName("connectButton"); // NOI18N
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        hostField.setText(resourceMap.getString("hostField.text")); // NOI18N
        hostField.setName("hostField"); // NOI18N

        portField.setText(resourceMap.getString("portField.text")); // NOI18N
        portField.setName("portField"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        defaultsButton.setText(resourceMap.getString("defaultsButton.text")); // NOI18N
        defaultsButton.setName("defaultsButton"); // NOI18N
        defaultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(defaultsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(typeSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(dbNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(hostField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(portField, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(cancelButton)
                    .addComponent(defaultsButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/** Adds if text is non-empty, and saves in properties node */
	private void addNonempty(String key, JTextField text, HashMap opts) {
		String val = text.getText();
		if (val.length() > 0)
			opts.put(key, val);
		props.put("db"+key, val);
	}

	/** Remove quotes */
	private String stripQuotes(String quoted){
		if(quoted.startsWith("\"") && quoted.endsWith("\"")
				|| quoted.startsWith("\'") && quoted.endsWith("\'"))
			return quoted.substring(1, quoted.length() - 1);
		return quoted;
	}

	/** Loads database information from the database.yml file in the default install. */
	private void reloadDefaults(){
		try{
			Scanner s;
			try{
				s = new Scanner(new File(System.getenv("BASE")+"config/database.yml"));
			} catch (FileNotFoundException fnfox){
				try{
					s = new Scanner(new File(MsfguiApp.getMsfRoot()+"/../config/database.yml"));
				} catch (FileNotFoundException fnfx){
					s = new Scanner(new File("/opt/metasploit/apps/pro/ui/config/database.yml"));
				}
			}
			String token = s.next();
			while(!token.equals("production:"))
				token = s.next();
			while(s.hasNext()){
				if(token.equals("adapter:"))
					props.put("dbdriver", stripQuotes(s.next()));
				else if(token.equals("database:"))
					props.put("dbdatabase", stripQuotes(s.next()));
				else if(token.equals("username:"))
					props.put("dbusername", stripQuotes(s.next()));
				else if(token.equals("password:"))
					props.put("dbpassword", stripQuotes(s.next()));
				else if(token.equals("host:"))
					props.put("dbhost", stripQuotes(s.next()));
				else if(token.equals("port:"))
					props.put("dbport", stripQuotes(s.next()));
				token = s.next();
			}
		} catch (FileNotFoundException fnfox){
			fnfox.printStackTrace();
		}
		showDefaults();
	}

	/** Takes the values stored in the proproot and display it */
	private void showDefaults() {
		hostField.setText(props.get("dbhost").toString());
		portField.setText(props.get("dbport").toString());
		usernameField.setText(props.get("dbusername").toString());
		passwordField.setText(props.get("dbpassword").toString());
		dbNameField.setText(props.get("dbdatabase").toString());
	}

	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
		try {
			success = tryConnect();
			if (!success)
				MsfguiApp.showMessage(myParent, "Failure connecting to database!");
		} catch (MsfException mex) {
			MsfguiApp.showMessage(myParent, mex);
		}
		setVisible(false);
	}
	/** Tries to connect to the database with given credentials */
	private boolean tryConnect() throws MsfException{
		Map status = (Map) rpcConn.execute("db.status");
		if(status.containsKey("db"))
			return true; // already connected
		HashMap opts = new HashMap();
		addNonempty("host", hostField, opts);
		addNonempty("port", portField, opts);
		addNonempty("username", usernameField, opts);
		addNonempty("password", passwordField, opts);
		addNonempty("database", dbNameField, opts);
		opts.put("driver", typeSpinner.getValue().toString());
		props.put("dbdriver", typeSpinner.getValue().toString());
		Map res = (Map) rpcConn.execute("db.connect",opts);
		return "success".equals(res.get("result"));
	}//GEN-LAST:event_connectButtonActionPerformed

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		setVisible(false);
	}//GEN-LAST:event_cancelButtonActionPerformed

	private void defaultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultsButtonActionPerformed
		reloadDefaults();
	}//GEN-LAST:event_defaultsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JTextField dbNameField;
    private javax.swing.JButton defaultsButton;
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField portField;
    private javax.swing.JSpinner typeSpinner;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
