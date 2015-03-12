package org.arong.egdownloader.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
/**
 * 分页组件
 * @author dipoo
 * @since 2015-03-12
 */
public class AJPager extends JPanel {

	private static final long serialVersionUID = 3076829356987409789L;
	
	private Integer pageCount;//总页数
	
	private Integer currentPage;//当前页数
	
	private Integer next;//下一页
	
	private Integer prev;//上一页
	
	private Integer maxPage = 7;
	
	//分页选项左边界
	private Integer minBound;
	
	//分页选项右边界
	private Integer maxBound;
	
	
	
	private ActionListener pageListener;
	
	public AJPager(int x, int y, int width, int height, ActionListener pageListener){
		this.setBounds(x, y, width, height);
		this.pageListener = pageListener;
		this.setLayout(new FlowLayout());
	}
	
	public void change( Integer countPage, Integer current){
		pageCount = countPage;
		currentPage = current;
		if(currentPage == null){
			currentPage = 1;
		}else{
			if(currentPage >= pageCount){
				currentPage = pageCount;
			}
			if(currentPage < 1){
				currentPage = 1;
			}
		}
		
		next = currentPage + 1;
		
		if(next > pageCount){
			next = pageCount;
		}
		
		prev = currentPage - 1;
		if(prev < 1){
			prev = 1;
		}
		
		if(pageCount <= maxPage){
			minBound = 1;
			maxBound = pageCount;
		}else{
			//增加因子，最大分页数中间距两边距离
			Integer m = maxPage / 2;
			//初步过滤
			//过滤左边界
			if(currentPage - m < 1){
				minBound = 1;
			}else{
				minBound = currentPage - m;
			}
			//过滤右边界
			if(currentPage + m > pageCount){
				maxBound = pageCount;
			}else{
				maxBound = currentPage + m;
			}
			//二次过滤
			if(minBound.equals(1)){
				maxBound = maxPage;
			}
			if(maxBound.equals(pageCount)){
				minBound = maxBound - maxPage + 1;
			}
		}
		this.removeAll();
		if(prev > 1){
			JButton btn = new JButton("上一页");
			btn.setName(prev + "");
			btn.setToolTipText(prev + "");
			if(pageListener != null){
				btn.addActionListener(pageListener);
			}
			this.add(btn);
		}
		for(int i = minBound; i <= maxBound; i++ ){
			JButton btn = new AJButton(" " + i + " ");
			btn.setName(i + "");
			if(i == currentPage){
				btn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
			}else{
				btn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
				if(pageListener != null){
					btn.addActionListener(pageListener);
				}
			}
			this.add(btn);
		}
		if(next <= pageCount){
			JButton btn = new JButton("下一页");
			btn.setToolTipText(next + "");
			btn.setName(next + "");
			if(pageListener != null){
				btn.addActionListener(pageListener);
			}
			this.add(btn);
		}
	}
	
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}


	public Integer getPageCount() {
		return pageCount;
	}


	public void setPageListener(ActionListener pageListener) {
		this.pageListener = pageListener;
	}


	public ActionListener getPageListener() {
		return pageListener;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getNext() {
		return next;
	}

	public Integer getPrev() {
		return prev;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public Integer getMinBound() {
		return minBound;
	}

	public Integer getMaxBound() {
		return maxBound;
	}

}
