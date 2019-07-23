package com.wwd.main.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		 // JobDetail
        JobDetail jobDetail = context.getJobDetail();
        // JobDataMap
        JobDataMap dataMap = jobDetail.getJobDataMap();
        String content = dataMap.getString("CONTENT");
        System.out.println(content);

	}

}
