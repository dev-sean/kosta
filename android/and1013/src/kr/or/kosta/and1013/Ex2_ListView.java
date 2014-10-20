package kr.or.kosta.and1013;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Ex2_ListView extends Activity implements OnItemClickListener {
	private ListView listv;
	ArrayList<HashMap<String, String>> mylist;
	HashMap<String, String> map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.ex2_listview);
		listv = (ListView) findViewById(R.id.ex2_list);
		// ListView�� ������ ���� ------------------
		mylist = new ArrayList<HashMap<String, String>>();
		
		map = new HashMap<String, String>();
		map.put("MemberID", "YaMan");
		map.put("Name", "HaHa");
		map.put("Tel", "010-1010-2932");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "Doni");
		map.put("Name", "Jung");
		map.put("Tel", "010-1432-2122");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "DDugi");
		map.put("Name", "You");
		map.put("Tel", "010-1340-2652");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "Nogari");
		map.put("Name", "Hong");
		map.put("Tel", "010-9580-6341");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "YaMan");
		map.put("Name", "HaHa");
		map.put("Tel", "010-1010-2932");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "YaMan");
		map.put("Name", "HaHa");
		map.put("Tel", "010-1010-2932");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "YaMan");
		map.put("Name", "HaHa");
		map.put("Tel", "010-1010-2932");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("MemberID", "YaMan");
		map.put("Name", "HaHa");
		map.put("Tel", "010-1010-2932");
		mylist.add(map);
		// --------------------------------------------
		SimpleAdapter sAdapter = null;
		// SimpleAdapter : xml�� �����͸� ���� ��ġ ������ �� �ִ�.
		// SimpleAdapter(context, data, ��ġ�� ���̾ƿ�:resource, data���� �о�� Ű���� �迭��
		// ����, ��ġ�� ���̾ƿ� ���ҽ����� �÷����� id�� ����
		sAdapter = new SimpleAdapter(this, mylist, R.layout.ex2_column,
				new String[] { "MemberID", "Tel", "Name" }, new int[] {
						R.id.ex2_memId, R.id.ex2_memTel,R.id.ex2_memName });
		//listview�� ����
		listv.setAdapter(sAdapter);
		
		listv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(Ex2_ListView.this, Ex2_Result.class);
		Bundle myBundle = new Bundle();
		//������ item�� �ش�Ǵ� ArrayList�κ��� HashMap�� ��ȯ�޴´�.
		HashMap<String, String> map = mylist.get(position);
		//Map���� Key�� �޾Ƴ���
		String idv = map.get("MemberID");
		String namev = map.get("Name");
		String telv = map.get("Tel");
		
		/*
		 * StringBuffer s = new StringBuffer();
		 * s.append(idv).append("/").append(namev).append("/").append(telv);
		 * Toast.makeText(Ex2_ListView.this, s.toString(), 3000).show();
		 */
		String[] sarr = {idv, namev, telv};
		myBundle.putStringArray("vo", sarr);
		intent.putExtras(myBundle);
		
		startActivity(intent);
		
	}
}