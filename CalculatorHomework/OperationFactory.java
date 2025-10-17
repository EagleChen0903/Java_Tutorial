import java.util.HashMap;
import java.util.Map;

public class OperationFactory {

    private static final Map<String, Operation> operationMap = new HashMap<>();

    // 靜態區塊：只在程式啟動時註冊一次
    static {
        operationMap.put("+", new AddOperation());
        operationMap.put("-", new SubOperation());
        operationMap.put("*", new MulOperation());
        operationMap.put("/", new DivOperation());
        // ✅ 未來要新增 → 只要這樣就好：operationMap.put("%", new ModOperation());
    }

    public static Operation getOperation(String operator) {
        Operation op = operationMap.get(operator);
        if (op == null) {
            throw new IllegalArgumentException("不支援的運算符號: " + operator);
        }
        return op;
    }
}
