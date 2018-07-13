package com.zqf.airquality.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zqf.airquality.domain.*;
import com.zqf.airquality.service.AqiService;
import com.zqf.airquality.util.PinyinUtil;

@Controller
@RequestMapping("aqi")
public class AqiController {
	
	@Resource(name="aqiService")
	private AqiService aqiService;
	
	private static final String AQI_LIST = "/airquality/airquality_list";
	
	private List<Double> formatDouble(List<Double> lists)
	{
		List<Double> results = new ArrayList<Double>();
		DecimalFormat df = new DecimalFormat("#.00");
		for(int i = 0; i < lists.size(); i++) {
			results.add(Double.valueOf(df.format(lists.get(i))));
		}
		return results;
	}
	
	private List<Double> formatHistoryDouble(List<AqiHistory> lists)
	{
		List<Double> results = new ArrayList<Double>();
		DecimalFormat df = new DecimalFormat("#.00");
		for(int i = 0; i < lists.size(); i++) {
			results.add(Double.valueOf(df.format(lists.get(i).getAvgaqi())));
		}
		return results;
	}
	
	private List<Double> concatList(List<Double> lista, List<Double> listb){
		List<Double> lists = new ArrayList<Double>();
		for(int i = 0; i < lista.size(); i++) {
			lists.add(lista.get(i));
		}
		System.out.println("\n\n\n\n"+lista.size()+"\n\n\n\n\n");
		for(int i = 0; i < listb.size(); i++) {
			lists.add(listb.get(i));
		}
		return lists;
	}
	
	private List<Aqi> getList()
	{
		List<Aqi> lists = aqiService.getAqiList();
		return lists;
	}
	
	private AqiPredict getPredictList(String city)
	{
		AqiPredict ap = aqiService.getAqiPredictList(city);
		return ap;
	}
	
	private List<AqiHistory> getHistoryList(String city)
	{
		List<AqiHistory> lists = aqiService.getAqiHistoryList(city);
		return lists;
	}
	
	private List<AqiCluster> getClusterList2016()
	{
		List<AqiCluster> lists = aqiService.getAqiClusterList2016();
		return lists;
	}
	
	private List<ClusterBound> getClusterBound()
	{
		List<ClusterBound> lists = aqiService.getAqiClusterListBound();
		List<ClusterBound> results = new ArrayList<ClusterBound>();
		DecimalFormat df = new DecimalFormat("#.00");
		for(ClusterBound cb:lists) {
			double downBound = Double.valueOf(df.format(cb.getMinpoint()));
			double upBound = Double.valueOf(df.format(cb.getMaxpoint()));
			ClusterBound newcb = new ClusterBound();
			newcb.setMinpoint(downBound);
			newcb.setMaxpoint(upBound);
			results.add(newcb);
		}
		return results;
	}
	
	private List<AqiCluster> getClusterList2017()
	{
		List<AqiCluster> lists = aqiService.getAqiClusterList2017();
		return lists;
	}
	
	private List<AqiCluster> getClusterList2018()
	{
		List<AqiCluster> lists = aqiService.getAqiClusterList2018();
		return lists;
	}
	
	private List<AqiRankBean> getRankList(RankParamBean rankParamBean)
	{
		List<AqiRank> lists = aqiService.getAqiRankList(rankParamBean);
		int rank = 1;
		List<AqiRankBean> oneLists = new ArrayList<AqiRankBean>();
		DecimalFormat df = new DecimalFormat("#.00");
		for(AqiRank aqirank:lists)
		{
			String city = aqirank.getCity();
			String avgaqi = df.format(aqirank.getAvgaqi());
			String avgpm25 = df.format(aqirank.getAvgpm25());
			String avgpm10 = df.format(aqirank.getAvgpm10());
			oneLists.add(new AqiRankBean(city, avgaqi, avgpm25, avgpm10, rank++));
		}
		return oneLists;
	}
	
	private List<AqiMonthAvg> getMonthAvgList(CityYear cy)
	{
		List<AqiMonthAvg> lists = aqiService.getAqiMonthAvgList(cy);
		DecimalFormat df = new DecimalFormat("#.00");
		List<AqiMonthAvg> results = new ArrayList<AqiMonthAvg>();
		for(int i = 0; i < lists.size(); i++) {
			AqiMonthAvg ama = lists.get(i);
			double faqi = Double.valueOf(df.format(ama.getAvgaqi()));
			AqiMonthAvg nama = new AqiMonthAvg();
			nama.setAvgaqi(faqi);
			nama.setMonth(ama.getMonth());
			results.add(nama);
		}
		return results;
	}
	
	private List<AitTemBean> getTemList(CityYear cy)
	{
		AitTem at = aqiService.getAirTemList(cy).get(0);
		List<AitTemBean> results = new ArrayList<AitTemBean>();
		String[] types = {"PM2.5", "PM10", "SO2", "NO2", "CO", "O3"};

		results.add(new AitTemBean(types[0], at.getPm25pearson(), at.getPm25spearman()));
		results.add(new AitTemBean(types[1], at.getPm10pearson(), at.getPm10spearman()));
		results.add(new AitTemBean(types[2], at.getSo2pearson(), at.getSo2spearman()));
		results.add(new AitTemBean(types[3], at.getNo2pearson(), at.getNo2spearman()));
		results.add(new AitTemBean(types[4], at.getCopearson(), at.getCospearman()));
		results.add(new AitTemBean(types[5], at.getO3pearson(), at.getO3spearman()));
		return results;
	}
	
	private List<AqiTrend> getTrendList(AqiTrendParamBean atpb)
	{
		List<AqiTrend> lists = aqiService.getAqiTrendList(atpb);
		return lists;
	}
	
	private List<City> getCList()
	{
		List<ProvinceCity> lists = aqiService.getCityList();
		List<City> results = new ArrayList<City>();
		List<CityPinYin> cityLists = new ArrayList<CityPinYin>();
		String lastprovince = "云南";
		for(ProvinceCity pc:lists)
		{
			String province = pc.getProvince();
			String city = pc.getCity();
			if(!province.equals(lastprovince))
			{
				results.add(new City(lastprovince, lastprovince, new ArrayList<CityPinYin>(cityLists)));
				lastprovince = province;
				cityLists.clear();
			}
			cityLists.add(new CityPinYin(city, city));
		}
		results.add(new City(lastprovince, lastprovince, new ArrayList<CityPinYin>(cityLists)));
		return results;
	}
	
	private List<CityLevelCount> getExcellentList()
	{
		List<CityLevelCount> lists = aqiService.getAqiExcellentList();
		int size = lists.size();
		int toIndex = size * 2 / 3;
		return lists.subList(0, toIndex);
	}
	
	private List<CityLevelCount> getGoodList()
	{
		List<CityLevelCount> lists = aqiService.getAqiGoodList();
		int size = lists.size();
		int toIndex = size * 2 / 3;
		return lists.subList(0, toIndex);
	}
	
	private List<CityLevelCount> getLightPollutionList()
	{
		List<CityLevelCount> lists = aqiService.getAqiLightPollutionList();
		int size = lists.size();
		int toIndex = size * 2 / 3;
		return lists.subList(0, toIndex);
	}
	
	private List<CityLevelCount> getMiddlePollutionList()
	{
		return aqiService.getAqiMiddlePollutionList();
	}
	
	private List<CityLevelCount> getHeavyPollutionList()
	{
		return aqiService.getAqiHeavyPollutionList();
	}
	
	private List<CityLevelCount> getSeriousPollutionList()
	{
		return aqiService.getAqiSeriousPollutionList();
	}
	
	private List<AqiTem> getTemperatureList(CityYear cy)
	{
		return aqiService.getTemperatureList(cy);
	}
	
	private List<AqiRain> getRainList(CityYear cy){
		List<AqiRain> lists = aqiService.getAqiRainList(cy);
		return lists;
	}
	
	public List<CityPm> getPmList(){
		List<CityPm> lists = aqiService.getCityPmList();
		List<CityPm> results = new ArrayList<CityPm>();
		DecimalFormat df = new DecimalFormat("#.00");
		for(int i = 0; i < lists.size(); i++) {
			CityPm cp = lists.get(i);
			double pm = Double.valueOf(df.format(cp.getAvgpm25()));
			CityPm newcp = new CityPm();
			newcp.setCity(cp.getCity());
			newcp.setAvgpm25(pm);
			results.add(newcp);
		}
		return results;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	public ModelAndView getAqiList()
	{
		ModelAndView mav = new ModelAndView(AQI_LIST);
		mav.addObject("aqiList", getList());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/predict")
	@ResponseBody
	public Map<String, Object> getAqiPredictList(@RequestBody CityBean cityBean)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		AqiPredict ap = getPredictList(cityBean.getCity());
		List<AqiHistory> lists = getHistoryList(cityBean.getCity());
		List<Double> formatLists = formatHistoryDouble(lists);
		String title = ap.getTitle();
		String city = ap.getCity();
		String province = ap.getProvince();
		
		List<Double> listone = new ArrayList<Double>();
		listone.addAll(Arrays.asList(ap.getOne(),ap.getTwo(),ap.getThree(),ap.getFour(),ap.getFive()));
		List<Double> listtwo = new ArrayList<Double>();
		listtwo.addAll(Arrays.asList(ap.getOnelo95(),ap.getTwolo95(),ap.getThreelo95(),ap.getFourlo95(),ap.getFivelo95()));
		List<Double> listthree = new ArrayList<Double>();
		listthree.addAll(Arrays.asList(ap.getOnelo80(),ap.getTwolo80(),ap.getThreelo80(),ap.getFourlo80(),ap.getFivelo80()));
		List<Double> listfour = new ArrayList<Double>();
		listfour.addAll(Arrays.asList(ap.getOnehi80(),ap.getTwohi80(),ap.getThreehi80(),ap.getFourhi80(),ap.getFivehi80()));
		List<Double> listfive = new ArrayList<Double>();
		listfive.addAll(Arrays.asList(ap.getOnehi95(),ap.getTwohi95(),ap.getThreehi95(),ap.getFourhi95(),ap.getFivehi95()));
		
		modelMap.put("title", title);
		modelMap.put("city", city);
		modelMap.put("province", province);
		
		modelMap.put("listone", concatList(formatLists, formatDouble(listone)));
		modelMap.put("listtwo", concatList(formatLists, formatDouble(listtwo)));
		modelMap.put("listthree", concatList(formatLists, formatDouble(listthree)));
		modelMap.put("listfour", concatList(formatLists, formatDouble(listfour)));
		modelMap.put("listfive", concatList(formatLists, formatDouble(listfive)));
		
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cluster2016")
	@ResponseBody
	public Map<String, Object> getAqiClusterList2016()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("aqiclusterlist2016", getClusterList2016());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/clusterbound")
	@ResponseBody
	public Map<String, Object> getAqiClusterBound()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("clusterbound", getClusterBound());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cluster")
	@ResponseBody
	public Map<String, Object> getAqiClusterList2017()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		List<AqiCluster> lists = getClusterList2017();
		List<CityGroup> groups = new ArrayList<CityGroup>();
		DecimalFormat df = new DecimalFormat("#.00");
		
		String city;
		String points;
		int grades = 2;
		int lastGrades = grades;
		String cityStr;
		List<String> cityLists = new ArrayList<String>();
		String[] groupLists = {"group1","group2","group3","group4","group5","group6"};
		int count = 0;
		
		for(int i = 0; i < lists.size(); i++)
		{
			AqiCluster ac = lists.get(i);
			city = ac.getCity();
			grades = ac.getGrades();
			points = df.format(ac.getPoints());
			cityStr = city+"("+points+")";
			if(lastGrades != grades)
			{
				if(cityLists.size() > 0) {
					groups.add(new CityGroup(new ArrayList<String>(cityLists)));
					cityLists.clear();
				}
				modelMap.put(groupLists[count++], new ArrayList<CityGroup>(groups));
				groups.clear();
				lastGrades = grades;
			}
			if(cityLists.size() == 6) {
				groups.add(new CityGroup(new ArrayList<String>(cityLists)));
				cityLists.clear();
			}
			cityLists.add(cityStr);
		}
		if(cityLists.size() > 0) {
			groups.add(new CityGroup(new ArrayList<String>(cityLists)));
			cityLists.clear();
		}
		modelMap.put(groupLists[count++], new ArrayList<CityGroup>(groups));
		groups.clear();
		lastGrades = grades;
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cluster2018")
	@ResponseBody
	public Map<String, Object> getAqiClusterList2018()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("aqiclusterlist2018", getClusterList2018());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rank")
	@ResponseBody
	public Map<String, Object> getAqiRankList(@RequestBody RankParamBean rankParamBean)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		List<AqiRankBean> lists = getRankList(rankParamBean);
		List<AqiRankBean> subLists = null;
		if(rankParamBean.getPage()*10 <= lists.size())
		{
			subLists = lists.subList((rankParamBean.getPage()-1)*10, rankParamBean.getPage()*10);
		}
		else
		{
			subLists = lists.subList((rankParamBean.getPage()-1)*10, lists.size());
		}
		modelMap.put("aqiranklist", subLists);
		modelMap.put("listsize", lists.size());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/monthavg")
	@ResponseBody
	public Map<String, Object> getAqiMonthAvgList(@RequestBody CityYear cy)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		List<AqiMonthAvg> lists = getMonthAvgList(cy);
		double minAqi = 1000.0;
		int minMonth = 0; 
		for(AqiMonthAvg amb:lists) {
			double aqi = amb.getAvgaqi();
			int month = amb.getMonth();
			if(aqi < minAqi) {
				minAqi = aqi;
				minMonth = month;
			}
		}
		modelMap.put("bestAqi", String.valueOf(minAqi));
		modelMap.put("bestMonth", minMonth);
		modelMap.put("aqimonthavglist", lists);
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/airtem")
	@ResponseBody
	public Map<String, Object> getAirTemList(@RequestBody CityYear cy)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("airtemlist", getTemList(cy));
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/airtrend")
	@ResponseBody
	public Map<String, Object> getAirTrendList(@RequestBody AqiTrendExtra ate)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		List<AqiTrend> lists = getTrendList(new AqiTrendParamBean(ate.getCity(), ate.getDateStart(), ate.getDateEnd()));
		List<AqiTrendSp> results = new ArrayList<AqiTrendSp>();
		List<AqiLevel> aqiLevelLists = new ArrayList<AqiLevel>();
		double maxnum = -1.0;
		double minnum = 10000;
		int cnt = lists.size();
		double sum = 0.0;
		double num = 0.0;
		String type = ate.getType();
		Map<String, Integer> counts = new HashMap<String, Integer>(); 
		String[] levels = {"优","良","轻度污染","中度污染","重度污染","严重污染"};
		double[] pm25levels = {0.0, 35.0, 75.0, 115.0, 150.0, 250.0, 1000.0};
		for(int i = 0; i < levels.length; i++)
		{
			counts.put(levels[i], 0);
		}
		for(AqiTrend at:lists)
		{
			String date = at.getDate();
			if("1".equals(type)) {
				num = at.getAqi();
				String level = at.getLevel();
				counts.put(level, counts.get(level)+1);
			}else if("2".equals(type)) {
				num = at.getPm25();
				for(int i = 0; i < pm25levels.length - 1; i++)
				{
					if(num >= pm25levels[i] && num <= pm25levels[i+1])
					{
						counts.put(levels[i], counts.get(levels[i])+1);
						break;
					}
				}
			}else if("3".equals(type)) {
				num = at.getPm10();
			}else if("4".equals(type)) {
				num = at.getSo2();
			}else if("5".equals(type)) {
				num = at.getNo2();
			}else if("6".equals(type)) {
				num = at.getCo();
			}else{
				num = at.getO3();
			}
			results.add(new AqiTrendSp(date, num));
			maxnum = Math.max(maxnum, num);
			minnum = Math.min(minnum, num);
			sum += num;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		double avg = sum / cnt;
		modelMap.put("airtrendlist", results);
		modelMap.put("max", df.format(maxnum));
		modelMap.put("min", df.format(minnum));
		modelMap.put("avg", df.format(avg));
		modelMap.put("city", ate.getCity());
		if("1".equals(type) || "2".equals(type)) {
			DecimalFormat dfp = new DecimalFormat("0.00%");
			for(int i = 0; i < levels.length; i++)
			{
				int levelcount = counts.get(levels[i]);
				aqiLevelLists.add(new AqiLevel(levels[i], levelcount, dfp.format((Double.valueOf(levelcount) / Double.valueOf(cnt)))));
			}
			modelMap.put("levellist", aqiLevelLists);
		}
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/citylist")
	@ResponseBody
	public Map<String, Object> getCityList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("citylist",getCList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/excellentlist")
	@ResponseBody
	public Map<String, Object> getCityExcellentList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("excellentlist",getExcellentList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/goodlist")
	@ResponseBody
	public Map<String, Object> getCityGoodList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("goodlist",getGoodList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/lightpollutionlist")
	@ResponseBody
	public Map<String, Object> getCityLightPollutionList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("lightpollutionlist",getLightPollutionList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/middlepollutionlist")
	@ResponseBody
	public Map<String, Object> getCityMiddlePollutionList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("middlepollutionlist",getMiddlePollutionList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/heavypollutionlist")
	@ResponseBody
	public Map<String, Object> getCityHeavyPollutionList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("heavypollutionlist",getHeavyPollutionList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/seriouspollutionlist")
	@ResponseBody
	public Map<String, Object> getCitySeriousPollutionList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("seriouspollutionlist",getSeriousPollutionList());
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/aqitemlist")
	@ResponseBody
	public Map<String, Object> getCitySeriousPollutionList(@RequestBody CityYear cy)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("aqitemlist",getTemperatureList(cy));
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/aqilevellist")
	@ResponseBody
	public Map<String, Object> getAqiLevelList(@RequestBody AqiTrendParamBean atpb)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		List<AqiLevelCount> lists = aqiService.getAqiLevelList(atpb);
		List<AqiLevelPercent> results = new ArrayList<AqiLevelPercent>();
		DecimalFormat dfp = new DecimalFormat("0.00");
		Map<String, String> map = new HashMap<String, String>();
		String[] levels = {"优","良","轻度污染","中度污染","重度污染","严重污染"};
		int sum = 0;
		double levelcount = 0;
		for(int i = 0; i < lists.size(); i++) {
			sum += lists.get(i).getCount();
		}
		for(int i = 0; i < lists.size(); i++) {
			AqiLevelCount aq = lists.get(i);
			String level = aq.getLevel();
			double count = Double.valueOf(aq.getCount());
			if("优".equals(level) || "良".equals(level))
			{
				levelcount += count;
			}
			String percent = dfp.format((count*100/sum));
			map.put(level, percent);
		}
		for(int i = 0; i < levels.length; i++) {
			if(!map.containsKey(levels[i])) {
				results.add(new AqiLevelPercent(levels[i], "0.00"));
			}else {
				results.add(new AqiLevelPercent(levels[i], map.get(levels[i])));
			}
		}
		modelMap.put("aqilevellist",results);
		modelMap.put("levelcount", levelcount);
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/aqirainlist")
	@ResponseBody
	public Map<String, Object> getAqiLevelList(@RequestBody CityYear cy)
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		List<AqiRain> lists = getRainList(cy);
		AqiRainResult rainaqi = new AqiRainResult("aqi");
		List<Double> yaqiList = new ArrayList<Double>();
		List<Double> naqiList = new ArrayList<Double>();
		AqiRainResult rainpm25 = new AqiRainResult("pm25");
		List<Double> ypm25List = new ArrayList<Double>();
		List<Double> npm25List = new ArrayList<Double>();
		AqiRainResult rainpm10 = new AqiRainResult("pm10");
		List<Double> ypm10List = new ArrayList<Double>();
		List<Double> npm10List = new ArrayList<Double>();
		AqiRainResult rainso2 = new AqiRainResult("so2");
		List<Double> yso2List = new ArrayList<Double>();
		List<Double> nso2List = new ArrayList<Double>();
		AqiRainResult rainno2 = new AqiRainResult("no2");
		List<Double> yno2List = new ArrayList<Double>();
		List<Double> nno2List = new ArrayList<Double>();
		AqiRainResult rainco = new AqiRainResult("co");
		List<Double> ycoList = new ArrayList<Double>();
		List<Double> ncoList = new ArrayList<Double>();
		AqiRainResult raino3 = new AqiRainResult("o3");
		List<Double> yo3List = new ArrayList<Double>();
		List<Double> no3List = new ArrayList<Double>();
		for(int i = 0; i < lists.size(); i++)
		{
			AqiRain ar = lists.get(i);
			DecimalFormat df = new DecimalFormat("#.00");
			yaqiList.add(Double.valueOf(df.format(ar.getYaqi())));
			ypm25List.add(Double.valueOf(df.format(ar.getYpm25())));
			ypm10List.add(Double.valueOf(df.format(ar.getYpm10())));
			yso2List.add(Double.valueOf(df.format(ar.getYso2())));
			yno2List.add(Double.valueOf(df.format(ar.getYno2())));
			ycoList.add(Double.valueOf(df.format(ar.getYco())));
			yo3List.add(Double.valueOf(df.format(ar.getYo3())));
			naqiList.add(Double.valueOf(df.format(ar.getNaqi())));
			npm25List.add(Double.valueOf(df.format(ar.getNpm25())));
			npm10List.add(Double.valueOf(df.format(ar.getNpm10())));
			nso2List.add(Double.valueOf(df.format(ar.getNso2())));
			nno2List.add(Double.valueOf(df.format(ar.getNno2())));
			ncoList.add(Double.valueOf(df.format(ar.getNco())));
			no3List.add(Double.valueOf(df.format(ar.getNo3())));
		}
		rainaqi.setyLists(yaqiList); rainaqi.setnLists(naqiList);
		rainpm25.setyLists(ypm25List); rainpm25.setnLists(npm25List);
		rainpm10.setyLists(ypm10List); rainpm10.setnLists(npm10List);
		rainso2.setyLists(yso2List); rainso2.setnLists(nso2List);
		rainno2.setyLists(yno2List); rainno2.setnLists(nno2List);
		rainco.setyLists(ycoList); rainco.setnLists(ncoList);
		raino3.setyLists(yo3List); raino3.setnLists(no3List);
		modelMap.put("rainaqi",rainaqi);
		modelMap.put("rainpm25",rainpm25);
		modelMap.put("rainpm10",rainpm10);
		modelMap.put("rainso2",rainso2);
		modelMap.put("rainno2",rainno2);
		modelMap.put("rainco",rainco);
		modelMap.put("raino3",raino3);
		return modelMap;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/pmlist")
	@ResponseBody
	public Map<String, Object> getCityPmList()
	{
		Map<String, Object> modelMap= new HashMap<String, Object>();
		modelMap.put("pmlist",getPmList());
		return modelMap;
	}
}
