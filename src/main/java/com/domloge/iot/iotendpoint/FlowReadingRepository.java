package com.domloge.iot.iotendpoint;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

@RepositoryRestResource(path = "flowReadings")
public interface FlowReadingRepository extends PagingAndSortingRepository<FlowReading, Integer> {

	List<FlowReading> findBySource(String source);
	
	List<FlowReading> findByHostname(String hostname);
	
	List<FlowReading> findByTimeGreaterThanEqual(
			@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
			@Param("time")Date from);
	
	List<FlowReading> findTop50By();
}