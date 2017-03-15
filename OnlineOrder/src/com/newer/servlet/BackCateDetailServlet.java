package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.newer.dao.CateDao;
import com.newer.model.Cate;

@WebServlet( name="backcatedetailServlet", urlPatterns="/backcatedetail" )
public class BackCateDetailServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CateDao dao = new CateDao();
		
		String str = req.getParameter( "str" );
		
		if( str.equals( "detail" ) ) {
			//查看单件商品信息
			int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
			Cate cate = dao.getOne( cate_id );
			req.setAttribute( "cate", cate );
			req.getRequestDispatcher( "backCateDetail.jsp" ).forward( req, resp );
		}else if( str.equals( "update" ) ) {
			//修改商品信息
			int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
			Cate cate = new Cate();
			Cate cateDemo = dao.getOne( cate_id );
			
			String cate_name = req.getParameter( "cate_name" );
			double price = Double.parseDouble( req.getParameter( "price" ) );
			String describe = req.getParameter( "describe" );
			String type = req.getParameter( "type" );
			String speces = req.getParameter( "speces" );
			
			cate.setCate_id( cateDemo.getCate_id() );
			cate.setCate_name( cate_name );
			cate.setPrice(price);
			cate.setDescribe(describe);
			if( type.equals( "川菜" ) ) {
				cate.setType( "2001" );
			} else if( type.equals( "湘菜" ) ) {
				cate.setType( "2002" );
			} else if( type.equals( "粤菜" ) ) {
				cate.setType( "2003" );
			}
			if( type.equals( "烧烤" ) ) {
				cate.setType( "3001" );
			} else if( type.equals( "酒水" ) ) {
				cate.setType( "3002" );
			} else if( type.equals( "烤鱼" ) ) {
				cate.setType( "3003" );
			}
			cate.setSpeces(speces);
			cate.setImg_path( cateDemo.getImg_path() );
			cate.setStatus( cateDemo.getStatus() );
			
			boolean flag = dao.updateCate(cate);
			if( flag ) {
				req.getRequestDispatcher( "succedDetail.jsp" ).forward( req, resp );
			}
		} else if( str.equals( "add" ) ) {
			//添加商品
			String cate_name = req.getParameter( "cate_name" );
			double price = Double.parseDouble( req.getParameter( "price" ) );
			String img_path = req.getParameter( "img_path" );
			String describe = req.getParameter( "describe" );
			String type = req.getParameter( "type" );
			String speces = req.getParameter( "speces" );
			
			Cate cate = new Cate();
			cate.setCate_name(cate_name);
			cate.setPrice(price);
			cate.setImg_path(img_path);
			cate.setDescribe(describe);
			if( type.equals( "川菜" ) ) {
				cate.setType( "2001" );
			}else if( type.equals( "湘菜" ) ) {
				cate.setType( "2002" );
			}else if( type.equals( "粤菜" ) ) {
				cate.setType( "2003" );
			}else if( type.equals( "烧烤" ) ) {
				cate.setType( "3001" );
			}else if( type.equals( "酒水" ) ) {
				cate.setType( "3002" );
			}else if( type.equals( "烤鱼" ) ) {
				cate.setType( "3003" );
			}
			cate.setSpeces(speces);
			//保存商品信息到数据库，并拿到添加的商品的id
			int cate_id = dao.addCateDemo(cate);
			System.out.println( cate_id );
			
			//上传文件
			SmartUpload su = new SmartUpload();
			System.out.println( "开始上传文件" );
			//初始化
			su.initialize( this.getServletConfig(), req, resp );
			System.out.println( "开始初始化" );
			
			try {
				//上传文件到服务器临时目录
				su.upload();
				System.out.println( "上传文件到服务器临时目录" );
				//获得所有上传的文件集合
				Files files = su.getFiles();
				//遍历文件集合
				for( int i = 0; i < files.getCount(); i++ ) {
					File file = files.getFile( i );
					//获取images文件加在服务器的绝对路径
					String dir = this.getServletContext().getRealPath( "images" );
					//获取旧文件名
					String oldName = file.getFileName();
					System.out.println( oldName );
					//定义新名字
					String newName = cate_id+"_"+i+oldName.substring( oldName.lastIndexOf( "." ) );
					//定义文件新的保存路径
					String path = dir+"/"+newName;
					//将文件保存在新路径
					file.saveAs( path );
					System.out.println( path );
					
					cate.setCate_id(cate_id);
					cate.setImg_path( newName );
					//修改数据库对象商品的图片值
					boolean flag = dao.updatePicture(cate);
					if( flag ) {
						req.getRequestDispatcher( "succedUser.jsp" ).forward( req, resp );
					}
				}
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
	}
}