package com.dsa.utils.node;


import com.dsa.utils.DealString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * tree 工具类
 * @author wsearl
 *
 */
public class NodeUtil {

	/**
	 * tree的初始化
	 * @param nodeList
	 * @param rootSuperId
	 * @return
	 */
	public static List<Node> toTreeList(List<Node> nodeList, String rootSuperId) {
		List<Node> nodes = new ArrayList<Node>();
		//String id = null;
		String superId = null;
		Map<String,Node> map = getMapNode(nodeList).get(0);
		for(Node node : nodeList){
			//id = node.getId();
			superId = node.getPid();
			if(map.containsKey(superId)){
				map.get(superId).getChildren().add(node);
			}
			else{
				if(!"".equals(DealString.toString(rootSuperId)) && superId.equals(rootSuperId)){
					nodes.add(node);
				}
				else if("".equals(DealString.toString(rootSuperId))){
					nodes.add(node);
				}
				//map.put(id, node);
			}
		}
		return nodes;
	}
	
	
	/**
	 * 遍历选择中数据的展示
	 * @param all
	 * 
	 * @param checkedId
	 * @param rootSuperId
	 * @return
	 */
	public static List<Node> toTreeList(List<Node> all, String checkedId, String rootSuperId){
		List<Node> nodes = new ArrayList<Node>();
		//String id = null;
		String superId = null;
		Map<String,Node> map = getMapNode(all).get(0);
		for(Node node : all){
			//id = node.getId();
			if(checkedId.equals(node.getId())){
				node.setChecked(true);
			}
			superId = node.getPid();
			if(map.containsKey(superId)){
				map.get(superId).getChildren().add(node);
			}
			else{
				if(!"".equals(DealString.toString(rootSuperId)) && superId.equals(rootSuperId)){
					nodes.add(node);
				}
				else if("".equals(DealString.toString(rootSuperId))){
					nodes.add(node);
				}
				//map.put(id, node);
			}
		}
		return nodes;
	}
	
	/**
	 * 数据筛选
	 * @param nodes
	 * @return
	 */
	private static List<Map<String, Node>> getMapNode(List<Node> nodes) {
		Map<String,Node> map = new HashMap<String, Node>();
		Map<String,Node> superMap = new HashMap<String, Node>();
		List<Map<String,Node>> list = new ArrayList<Map<String,Node>>();
		for(Node node : nodes){
			if(!map.containsKey(node.getId())){
				map.put(node.getId(), node);
				superMap.put(node.getPid(), node);
			}
		}
		list.add(map);
		list.add(superMap);
		return list;
	}
}
