package june15th;

import java.awt.Button;
import java.awt.Frame;
public class Swing
{
	Frame frame = new Frame("������");
	Button button = new Button("������");
	
	public void createFrame()
	{
		//�����ӿ� ������Ʈ �߰�
		frame.add(button);
		
		//������ ũ�� ����
		frame.setSize(300, 600);
		
		//������ ���̱�
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		//������ ����
		Swing frameExam = new Swing();
		frameExam.createFrame();
		Exception e;
	}
}
