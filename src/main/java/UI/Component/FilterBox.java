package UI.Component;



import UI.UIStyle;
import controller.SeatsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FilterBox extends JPanel
{
    private Font font;
    private FontMetrics mt;
    private String color;
    private int num;
    private ArrayList<JCheckBox> options = new ArrayList<>();
    private JComboBox options2;
    private boolean isSingleSelected = false;
    public FilterBox(int x,int y,int w, int h, String contents[], String color, boolean isSingleSelected)
    {
        this(x,y,w,h, contents, color);
        this.isSingleSelected = isSingleSelected;
    }

    public void setState(boolean state, int index)
    {
        if(options2 != null)
            options2.setSelectedIndex(index);
        else
            options.get(index).setSelected(state);
    }
    public void classCheck(String cls){
        for(JCheckBox j:options){
            if(j.getText().equals(cls)){
                j.setSelected(true);
            }
        }
    }
    public boolean[] getStates()
    {
        if(options2 != null)
        {
            boolean states[] = new boolean[num];
            for(int i = 0; i < states.length; i++)
                states[i] = false;
            states[options2.getSelectedIndex()] = true;
            return states;

        }
        boolean states[] = new boolean[options.size()];
        int cnt = 0;
        for(JCheckBox o : options)
        {
            states[cnt] = o.isSelected();
            cnt++;
        }
        return states;
    }

    public FilterBox(int x,int y,int w, int h,  String contents[], String color)
    {
        setLayout(null);
        num = contents.length - 1;
        this.color = color;
        font = UIStyle.NORMAL_FONT;
        if(color.equals("dark"))
            this.setBackground(Color.decode("#14151A"));
        else
            this.setBackground(Color.white);
        mt = Toolkit.getDefaultToolkit().getFontMetrics(font);

        JLabel head = new JLabel(contents[0]);
        head.setFont(font);
        if(color.equals("dark"))
            head.setForeground(Color.white);
        else
            head.setForeground(Color.black);
        int position = 50;
        int space = 20;

        head.setBounds(10, 0, mt.stringWidth(contents[0]) + space * 3, 40);
        this.add(head);
        this.setVisible(true);
        this.setBounds(x, y,w, h);

        if(contents.length < 8)
            for(int i = 1; i < contents.length; i++)
            {
                JCheckBox option = new JCheckBox(contents[i]);
                option.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(isSingleSelected) {
                            if (option.isSelected()) {
                                boolean res=SeatsController.getController().getSeatsPanel().changeCard(option.getText());
                                option.setSelected(res);
                                if(res){
                                    for (JCheckBox j : options) {
                                        if (j != option) {
                                            j.setSelected(false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
                options.add(option);
                option.setFont(font);
                if(color.equals("dark"))
                    option.setForeground(Color.white);
                else
                    option.setForeground(Color.BLACK);
                int StringWidth = mt.stringWidth(contents[i]);
                option.setBounds(position, 0, StringWidth+space*2, 35);
                position += StringWidth + space*2;
                this.add(option);
            }
        else
        {
            String[] optionContent = new String[contents.length - 1];
            for(int i = 1; i < contents.length; i++)
            {
                optionContent[i - 1] = contents[i];
            }
            options2 = new JComboBox(optionContent);
            options2.setFont(font);
            Arrays.sort(optionContent, (String s1, String s2) -> {
                return s2.length() - s1.length();
            });
            int StringWidth = mt.stringWidth(optionContent[0]);
            options2.setBounds(position, 0, StringWidth+space*2, 40);
            this.add(options2);
        }

        for (JCheckBox j : options) {
            if(color.equals("dark"))
                j.setBackground(Color.decode("#14151A"));
            else
                j.setBackground(Color.white);
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new HashMap<RenderingHints.Key, Object>() {{
            put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        }});
        if(color.equals("dark"))
            g2.setPaint(Color.decode("#EC9730"));
        else
            g2.setPaint(UIStyle.BLUE_SHALLOW);
        g2.drawLine(0, 39, (int)UIStyle.width, 39);
    }
}
