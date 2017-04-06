package monitorx.schedule;

import monitorx.domain.Node;
import monitorx.domain.syncType.PushSyncTypeConfig;
import monitorx.domain.syncType.SyncTypeEnum;
import monitorx.service.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Check if push type node is still pushing status data
 */
@Component
public class PushNodeStatusSchedule {

    @Autowired
    NodeService nodeService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 1000 * 10)
    public void checkPushStatus() {
        for (Node node : nodeService.getNodes()) {
            if (node.getSyncTypeEnum() == SyncTypeEnum.PUSH && node.getStatus() != null && node.getStatus().getLastUpdateDate() != null) {
                long seconds = (new Date().getTime() - node.getStatus().getLastUpdateDate().getTime()) / 1000;
                int interval = 30;

                PushSyncTypeConfig config = ((PushSyncTypeConfig) node.getSyncTypeConfig());
                if (config.getInterval() != null) {
                    interval = config.getInterval();
                }
                if (seconds > interval) {
                    node.getStatus().setStatus("down");
                    logger.warn("Node is down:" + node.getCode());

                    nodeService.addCheckPoints(node);
                }
            }
        }
    }
}