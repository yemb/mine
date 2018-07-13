package com.zqf.airquality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqf.airquality.domain.*;
import com.zqf.airquality.persistence.AqiMapper;

@Service
public class AqiService {

	@Autowired
	private AqiMapper aqiMapper;
	
	public List<Aqi> getAqiList()
	{
		return aqiMapper.getAqiList();
	}
	
	public AqiPredict getAqiPredictList(String city)
	{
		return aqiMapper.getAqiPredictList(city);
	}
	
	public List<AqiCluster> getAqiClusterList2016()
	{
		return aqiMapper.getAqiClusterList2016();
	}
	
	public List<AqiCluster> getAqiClusterList2017()
	{
		return aqiMapper.getAqiClusterList2017();
	}
	
	public List<AqiCluster> getAqiClusterList2018()
	{
		return aqiMapper.getAqiClusterList2018();
	}
	
	public List<AqiRank> getAqiRankList(RankParamBean rankParamBean)
	{
		return aqiMapper.getAqiRankList(rankParamBean);
	}
	
	public List<AqiMonthAvg> getAqiMonthAvgList(CityYear cy)
	{
		return aqiMapper.getAqiMonthAvgList(cy);
	}
	
	public List<AitTem> getAirTemList(CityYear cy)
	{
		return aqiMapper.getAirTemList(cy);
	}
	
	public List<AqiTrend> getAqiTrendList(AqiTrendParamBean atpb)
	{
		return aqiMapper.getAqiTrendList(atpb);
	}
	
	public List<ProvinceCity> getCityList()
	{
		return aqiMapper.getCityList();
	}

	public List<CityLevelCount> getAqiExcellentList() {
		return aqiMapper.getAqiExcellentList();
	}

	public List<CityLevelCount> getAqiGoodList() {
		return aqiMapper.getAqiGoodList();
	}
	
	public List<CityLevelCount> getAqiLightPollutionList() {
		return aqiMapper.getAqiLightPollutionList();
	}
	
	public List<CityLevelCount> getAqiMiddlePollutionList() {
		return aqiMapper.getAqiMiddlePollutionList();
	}
	
	public List<CityLevelCount> getAqiHeavyPollutionList() {
		return aqiMapper.getAqiHeavyPollutionList();
	}
	
	public List<CityLevelCount> getAqiSeriousPollutionList() {
		return aqiMapper.getAqiSeriousPollutionList();
	}

	public List<AqiTem> getTemperatureList(CityYear cy) {
		return aqiMapper.getTemperatureList(cy);
	}
	
	public List<AqiLevelCount> getAqiLevelList(AqiTrendParamBean atpb){
		return aqiMapper.getAqiLevelList(atpb);
	}
	
	public List<AqiHistory> getAqiHistoryList(String city){
		return aqiMapper.getAqiHistoryList(city);
	}
	
	public List<AqiRain> getAqiRainList(CityYear cy){
		return aqiMapper.getAqiRainList(cy);
	}
	
	public List<CityPm> getCityPmList(){
		return aqiMapper.getCityPmList();
	}
	
	public List<ClusterBound> getAqiClusterListBound(){
		return aqiMapper.getAqiClusterListBound();
	}
}
