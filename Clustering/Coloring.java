package Clustering;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import Graph.Network;
import Graph.Node;

public class Coloring {
	public static void RunAsyncColoring(Network net) throws IOException{
		int i=1;
		ArrayList<Node> lista=new ArrayList<Node>();
		for(Node s:net.getNodes()) {
			s.setCluster(i);
			i++;
			lista.add(s);
		}
		int szamol=0;
		while(true){
			System.out.println(szamol++);
			int mennyi=0;
			Collections.shuffle(lista);
			
			for(Node s: lista){
				int uj=s.getAsyncNewColor(net.getNodes().size());
				if(uj!=s.getCluster()){
					mennyi++;
					//System.out.println(s.getId()+"---"+s.getCluster()+"---->"+uj);
					s.setCluster(uj);
				}
				
			}
			if(mennyi==0){
				break;
			}
		}
		
		lista.sort((o1, o2) -> o1.getCluster()-o2.getCluster());
		File file = new File("clusters.txt");
	    file.createNewFile();
	    FileWriter writer = new FileWriter(file); 
		for(int j=0;j<lista.size();j++){
			writer.write(lista.get(j).getId()+";"+lista.get(j).getCluster()+"\n");
		}
		writer.flush();
		writer.close();
		Set<Integer> kozossegek=new HashSet<Integer>();
		for(Node a:lista){
			kozossegek.add(a.getCluster());
		}
		System.out.println("Közössegek szama:"+kozossegek.size());
	}

	public static void RunSyncColoring(Network net) throws IOException{
		int i=1;
		ArrayList<Node> lista=new ArrayList<Node>();
		for(Node s:net.getNodes()) {
			s.setCluster(i);
			s.setOldcluster(i);
			i++;
			lista.add(s);
		}
		int szamol=0;
		while(true){
			
			System.out.println(szamol++);
			int mennyi=0;
			for(Node s: lista){
				s.setOldcluster(s.getCluster());
			}
			
			
			
			for(Node s: lista){
				
				int uj=s.getSyncNewColor(net.getNodes().size());
				if(uj!=s.getOldcluster()){
					mennyi++;
					System.out.println(s.getId()+"---"+s.getCluster()+"---->"+uj);
					s.setCluster(uj);
				}
				
			}
			if(mennyi==0){
				break;
			}
			
		}
		
		lista.sort((o1, o2) -> o1.getCluster()-o2.getCluster());
		File file = new File("clusters.txt");
	    file.createNewFile();
	    FileWriter writer = new FileWriter(file); 
		for(int j=0;j<lista.size();j++){
			writer.write(lista.get(j).getId()+";"+lista.get(j).getCluster()+"\n");
		}
		writer.flush();
		writer.close();
		Set<Integer> kozossegek=new HashSet<Integer>();
		for(Node a:lista){
			kozossegek.add(a.getCluster());
		}
		System.out.println("Közössegek szama:"+kozossegek.size());
	}
}
