package components;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ShowWords extends JTable{
	private static final long serialVersionUID = 1L;
	private int rows,columns,length;
	
	public ShowWords(int rows, int columns) {
		super(new DefaultTableModel(rows,columns));
		this.rows = rows;
		this.columns = columns;
		this.length = 0;
		this.setForeground(Color.WHITE);
		this.setOpaque(false);
		this.setShowGrid(false);

	
	}
	
	public void setContainerSize(int width, int height) {
		this.setSize(width, height);
		System.out.println("width" + this.getWidth());
		this.setRowHeight(height/rows);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setOpaque(false);

		this.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		for(int i= 0; i < this.columns; i++) {
			this.getColumnModel().getColumn(i).setMinWidth(width/columns);
			this.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		this.getColumnModel().getColumn(this.columns-1).setMaxWidth(Integer.MAX_VALUE);
		System.out.println(this.getDefaultRenderer(Object.class));
	}
	
	public void addWord(String word) {
		
		for(int i = 0; i< this.rows; i++) {
			for(int j=0; j < this.columns; j++) {
				if(this.getModel().getValueAt(i, j) == null) {
					System.out.println(length);
					if(word.length() > length) {
						length = word.length();
						System.out.println(length);
					}
					float size = ((13-this.length)*2)+30;
					this.setFont(GameFont.nasalization.deriveFont(size));
					this.getModel().setValueAt(word, i, j);
					return;
				}
			}
		}
	}
	
	

}
