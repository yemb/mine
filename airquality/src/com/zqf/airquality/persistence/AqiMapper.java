package com.zqf.airquality.persistence;

import java.util.List;

import com.zqf.airquality.domain.*;

public interface AqiMapper {
	List<Aqi> getAqiList();
	AqiPredict getAqiPredictList(String city);
	List<AqiCluster> getAqiClusterList2016();
	List<AqiCluster> getAqiClusterList2017();
	List<AqiCluster> getAqiClusterList2018();
	List<AqiRank> getAqiRankList(RankParamBean rankParamBean);
	List<AqiMonthAvg> getAqiMonthAvgList(CityYear cy);
	List<AitTem> getAirTemList(CityYear cy);
	List<AqiTrend> getAqiTrendList(AqiTrendParamBean atpb);
	List<ProvinceCity> getCityList();
	List<CityLevelCount> getAqiExcellentList();
	List<CityLevelCount> getAqiGoodList();
	List<CityLevelCount> getAqiLightPollutionList();
	List<CityLevelCount> getAqiMiddlePollutionList();
	List<CityLevelCount> getAqiHeavyPollutionList();
	List<CityLevelCount> getAqiSeriousPollutionList();
	List<AqiTem> getTemperatureList(CityYear cy);
	List<AqiLevelCount> getAqiLevelList(AqiTrendParamBean atpb);
	List<AqiHistory> getAqiHistoryList(String city);
	List<AqiRain> getAqiRainList(CityYear cy);
	List<CityPm> getCityPmList();
	List<ClusterBound> getAqiClusterListBound();
}
