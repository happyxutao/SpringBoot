package wordTest;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.thymeleaf.engine.TemplateData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test1() throws IOException {
        String path="F:\\code\\SpringBoot\\src\\test\\java\\doc\\wordTemplete.docx";
        XWPFTemplate template = XWPFTemplate.compile(path);
        Map<String,Object> map=new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("date", dateFormat.format(new Date()).toString());
        template.render(map);
        template.writeAndClose(Files.newOutputStream(Paths.get("F:\\code\\SpringBoot\\src\\test\\java\\doc\\word.docx")));
    }

    @Test
    public void test3() throws IOException {
        String path="F:\\code\\SpringBoot\\src\\test\\java\\doc\\tableTemplate.docx";
        XWPFTemplate template = XWPFTemplate.compile(path);
        Map<String,Object> map=new HashMap<>();
        RowRenderData row0 = Rows.of("姓名", "年龄","图片").center().bgColor("8FBF9F").textColor("833500").create();
        RowRenderData row1 = Rows.of("张姗", "20").center().create();
        PictureRenderData img=Pictures.of("F:\\code\\SpringBoot\\src\\test\\java\\doc\\741678.jpg").size(100,50).create();
        CellRenderData cellRenderData=Cells.of(img).create();
        row1.addCell(cellRenderData);
        RowRenderData row2 = Rows.of("立式", "19").center().create();
        row2.addCell(cellRenderData);
        TableRenderData tableRenderData = Tables.create(row0, row1, row2);
        map.put("table",tableRenderData );
        template.render(map);
        template.writeAndClose(Files.newOutputStream(Paths.get("F:\\code\\SpringBoot\\src\\test\\java\\doc\\word1.docx")));
    }

    @Test
    public void test4() throws IOException {
        String path="F:\\code\\SpringBoot\\src\\test\\java\\doc\\imgTemplate.docx";
        XWPFTemplate template = XWPFTemplate.compile(path);
        Map<String,Object> map=new HashMap<>();
        PictureRenderData img=Pictures.of("F:\\code\\SpringBoot\\src\\test\\java\\doc\\741678.jpg").size(100,50).create();
        map.put("img",img);
        template.render(map);
        template.writeAndClose(Files.newOutputStream(Paths.get("F:\\code\\SpringBoot\\src\\test\\java\\doc\\img.docx")));
    }


}
