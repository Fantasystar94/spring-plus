package org.example.expert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

@Component
@Profile("local")   //로컬에서만 실행
@Slf4j
public class BulkInsert implements ApplicationRunner {

    private final DataSource dataSource;

    public BulkInsert(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        boolean started = false;
        if (started) {
            int total = 5_000_000;
            int batchSize = 10_000;

            String sql = """
            INSERT INTO users
            (email, nickname, password, user_role, created_at, modified_at)
            VALUES (?, ?, ?, ?, NOW(), NOW())
        """;
            String encodedPassword = "1234";

            try (Connection conn = dataSource.getConnection()) {
                conn.setAutoCommit(false);

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 1; i <= total; i++) {

                        ps.setString(1, "user" + i + "@test.com");
                        ps.setString(2, generateNickname(i));
                        ps.setString(3, encodedPassword);
                        ps.setString(4, "USER");
                        ps.addBatch();

                        if (i % batchSize == 0 ) {
                            ps.executeBatch();
                            conn.commit();
                            ps.clearBatch();
                            log.info("{} 건 삽입 완료",i);

                        }
                    }
                    ps.executeBatch();
                    conn.commit();
                }
            }
            log.info("생성 완료");
        }
    }

    public String generateNickname(int i ) {
        return "user_"+ UUID.randomUUID().toString().substring(0,8) + "_" + i;
    }
}
