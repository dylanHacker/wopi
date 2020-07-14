package com.dylan.wopi.dto;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 字符串处理工具包
 * 
 * @author Administrator
 */

public class StringUtil {

	/**
	 * 得到小数点后两位并且四舍五入 // private static DecimalFormat df = new
	 * DecimalFormat("0.00");
	 * 
	 * @param num
	 * @return
	 */
	public static String subDouble(double num) {
		DecimalFormat df = new DecimalFormat("#0.00");
		BigDecimal b = new BigDecimal(num);
		double price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return df.format(price);
	}

	/**
	 * 得到小数点后两位并且四舍五入
	 * 
	 * @param num
	 * @return
	 */
	public static double toDouble(double num) {
		BigDecimal b = new BigDecimal(num);
		double price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return price;
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 判断是否为空
	 * 
	 * @param val
	 * @return
	 */
	public static boolean unEmpty(String val) {
		if (val != null && !"".equalsIgnoreCase(val)) {
			return true;
		}
		return false;
	}

	// 去空
	public static String trim(String val) {
		if (val != null && !"".equalsIgnoreCase(val)) {
			return val.trim();
		}
		return null;
	}

	/**
	 * 自合条件
	 * 
	 * @param val
	 * @return
	 */
	public static String cToParams(String... val) {
		if (val != null && val.length > 0) {
			String tmp = "";
			for (String str : val) {
				tmp += "#" + str;
			}
			return tmp.substring(1);
		}
		return null;
	}

	/**
	 * //组合条件
	 * 
	 * @param val1
	 *            字段名
	 * @param val2
	 *            变量
	 * @return
	 */
	public static String convToParam(String val1, String val2, String val3) {
		if (val3 != null) {
			val3 = val3.trim();// 防止过多空格影响拼接结果
		}
		// 常用条件
		String[] conditions = { "like", "=", "<", "<=", ">", ">=", "!=", "in" };
		// 拼接结果
		String[] result = { " like '%" + val3 + "%'", "='" + val3 + "'", "<'" + val3 + "'", "<='" + val3 + "'",
				">'" + val3 + "'", ">='" + val3 + "'", "!='" + val3 + "'", " in('" + val3 + "')" };
		// 转换为list
		List<String> tempList = Arrays.asList(conditions);
		List<String> resultList = Arrays.asList(result);
		if (val3 != null) {
			if (tempList.contains(val2)) {
				return val1 + resultList.get(tempList.indexOf(val2));
			}
		}
		return null;
	}

	/**
	 * 查询中中文字符串编码转换
	 * 
	 * @param val
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String convToUtf8(String val) throws UnsupportedEncodingException {
		return new String(val.getBytes("iso-8859-1"), "utf-8");
	}

	// 判断list集合是否为空
	public static boolean listNotEmpty(List<?> list) {
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串转double
	 * 
	 * @param params
	 */
	public static double convDouble(String params) {
		return Double.parseDouble(params);
	}

	/**
	 * 字符串转float
	 * 
	 * @param params
	 * @return
	 */
	public static float convFloat(String params) {
		return Float.parseFloat(params);
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		if (obj != null) {
			if (!obj.toString().isEmpty() && "" != obj.toString() && !"null".equalsIgnoreCase(obj.toString())
					&& obj.toString().length() > 0) {
				return true;
			}
		}
		return false;
	}

	public synchronized static String getTokenId(int length) {
		String tmp = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "num" : "char";
			if ("char".equalsIgnoreCase(charOrNum)) {
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				tmp += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				tmp += String.valueOf(random.nextInt(10));
			}
		}
		return System.currentTimeMillis() + tmp;
	}

	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos != -1) {
			return fileName.substring(pos);
		} else {
			return "";
		}
	}

	// To ASCII
	public static String toAscii(String value) {
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i != chars.length - 1) {
				sbu.append((int) chars[i]).append(",");
			} else {
				sbu.append((int) chars[i]);
			}
		}
		return sbu.toString();
	}

	// 整形排序
	public static void bubbleSort(int[] numbers) {
		int temp; // 记录临时中间值
		int size = numbers.length; // 数组大小
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] < numbers[j]) { // 交换两数的位置
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	public static String getSuffix(int id) {

		switch (id) {
		case 1:
			return ".jpg";
		case 2:
			return ".html";
		case 3:
			return ".txt";
		case 4:
			return ".png";
		case 5:
			return ".gif";
		case 6:
			return ".bmp";
		case 7:
			return ".css";
		default:
			return "UNKNOWN";
		}
	}

	// 针对List<String>集合进行顺序排序 Long
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Long> sortLongASCList(List<String> idsList) {
		Collections.sort(idsList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return new Double((String) o1).compareTo(new Double((String) o2));
			}
		});
		List<Long> ids = new ArrayList<Long>();
		for (String str : idsList) {
			ids.add(Long.valueOf(str));
		}
		return ids;
	}

	// 针对List<String>集合进行顺序排序 Long
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> sortStringASCList(List<String> idsList) {
		Collections.sort(idsList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return new Double((String) o1).compareTo(new Double((String) o2));
			}
		});
		return idsList;
	}

	// 针对List<String>集合进行逆序排序 Long
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Long> sortLongDESCList(List<String> idsList) {
		Collections.sort(idsList, new Comparator() {
			@Override
			public int compare(Object o2, Object o1) {
				return new Double((String) o1).compareTo(new Double((String) o2));
			}
		});
		List<Long> ids = new ArrayList<Long>();
		for (String str : idsList) {
			ids.add(Long.valueOf(str));
		}
		return ids;
	}

	// 针对List<String>集合进行逆序排序 String
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> sortStringDESCList(List<String> idsList) {
		Collections.sort(idsList, new Comparator() {
			@Override
			public int compare(Object o2, Object o1) {
				return new Double((String) o1).compareTo(new Double((String) o2));
			}
		});
		return idsList;
	}

	/**
	 * List<String>去重
	 * 
	 * @param dataList
	 *            待处理数据集合
	 * @return
	 */
	public static List<String> toHeavy(List<String> dataList) {
		return new ArrayList<String>(new HashSet<String>(dataList));
	}

	/**
	 * 
	 * @param dataList
	 * @return
	 */
	public static List<Long> toLongHeavy(List<String> dataList) {
		// List<Long> list = new ArrayList<Long>();
		Set<Long> list = new HashSet<Long>();
		for (String str : dataList) {
			list.add(Long.valueOf(str));
		}
		return new ArrayList<Long>(list);
	}

	/**
	 * 处理Set集合返回List集合
	 * 
	 * @param sets
	 *            待处理的set集合
	 * @return List<String>集合
	 */
	public static List<String> converSToL(Set<String> sets) {
		List<String> list = new ArrayList<String>();
		Iterator<String> its = sets.iterator();
		while (its.hasNext()) {
			list.add(its.next());
		}
		return list;
	}

	/**
	 * 通过系统实现数组合并
	 * 
	 * @param first
	 *            第一个数组
	 * @param second
	 *            第二个数组
	 * @return 合并后的数组
	 */
	public static String[] concat(String[] first, String[] second) {
		String[] arr = new String[first.length + second.length];
		System.arraycopy(first, 0, arr, 0, second.length);
		;
		System.arraycopy(second, 0, arr, first.length, second.length);
		return arr;
	}

	/**
	 * 合并无限个数组
	 * 
	 * @param first
	 *            第一个
	 * @param refer
	 *            后续多个
	 * @return 合并后结果
	 */
	@SafeVarargs
	public static <T> T[] concatAll(T[] first, T[]... refer) {
		if (refer != null && refer.length > 0) {
			int count = 0;
			for (T[] str : refer) {
				count += str.length;
			}
			T[] result = Arrays.copyOf(first, count);
			int offset = first.length;
			for (T[] arr : refer) {
				System.arraycopy(arr, 0, result, offset, arr.length);
				offset += arr.length;
			}
			return result;
		}
		return first;
	}

	/**
	 * 乱码转换
	 * 
	 * @param val
	 * @return
	 */
	public String convStr(String val) {
		if (val != null && val.length() > 0) {
			try {
				if (!(java.nio.charset.Charset.forName("GBK").newEncoder().canEncode(val))) {
					return new String(val.getBytes("ISO-8859-1"), "UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				// 转码失败后原字符串返回
				return val;
			}
		}
		return val;
	}

	/**
	 * sql特殊字符检测
	 * 
	 * @param val
	 * @return
	 */
	public static boolean sqlSpecialChart(String val) {
		// "select", "update", "insert", "delete", "declare", "@", "exec",
		// "dbcc", "alter", "drop", "create", "backup", "if", "else", "end",
		// "and", "or", "add", "set“, ”open“, ”close“, ”use“, ”begin“, ”retun“,
		// ”as“, ”go“, ”exists“
		String[] str = new String[] { "'", "<", ">", "%", "\"\"", ",", ".", ">=", "=<", "<>", "-", "_", ";", "||", "[",
				"]", "&", "/", "-", "|", " ", "select", "update", "insert", "delete", "declare", "@", "exec", "dbcc",
				"alter", "drop", "create", "backup", "if", "else", "end", "and", "or", "add", "set", "open", "close",
				"use", "begin", "retun", "as", "go", "exists" };
		if (Arrays.asList(str).contains(val)) {
			return true;
		}
		return false;
	}

//	public static void main(String[] args) {
//		// System.out.println(cToParams("1","0","5","0","5","0","5","0","5","0","5","0","5"));
//		// System.out.println(convToParam("name", "like", "1231321"));
//		// double myNum2 = 111231;
//		// java.math.BigDecimal b = new java.math.BigDecimal(myNum2);
//		// DecimalFormat df = new DecimalFormat("#.00");
//		// double myNum3 = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP)
//		// .doubleValue();
//		// System.out.println(myNum2);
//		// System.out.println(df.format(myNum3));
//
//		// System.out.println(getToDayStartTime() + "\n" + getToDayEndTime());
//
//		// System.out.println(getSpecifiedStartTime(-30) + "\n" +
//		// getSpecifiedEndTime(1));
//
//		// for (int i = 0; i < 100; i++)
//		// System.out.println(getTokenId(5));
//
//	}

}
