/**
 * 
 * 力扣：394字符串解码
 * 
 * 
 * 思路：
 * 
 * 你的直觉非常敏锐，这正是很多人刚看双栈时最容易绕晕的地方。

但它**并没有错位**，关键在于：**`strStack` 存的根本不是“括号里的字符”，而是“括号外面的前缀”**。

---

**把括号看成“进房间干活”**

以 `a2[c]` 为例：

1. **在进房间前（遇到 `2[` 之前）**：
* 门外已经有字符串 `curStr = "a"`，当前数字是 `k = 2`。


2. **遇到 `[`（进门暂存）**：
* 你要把进门前的所有家当存进保险柜：
* `countStack.push(2)`（存的是：等会儿房间里的东西要放大 2 倍）
* `strStack.push("a")`（存的是：**门外原来有的前缀 `"a"**`）


* 然后把手头清空（`curStr = ""`），进去专心处理房间里的内容。


3. **在房间内**：
* 读到了 `'c'`，此时手头正在处理的 `curStr = "c"`。


4. **遇到 `]`（出门结算）**：
* 取出保险柜里的倍数：`repeatTimes = 2`。
* 取出保险柜里的前缀：`prevStr = "a"`。
* **算账**：用倍数 `2` 乘上**当前手头**搞出来的东西（`"c"`），得到 `"cc"`，再追加到**前缀**后面：
* `prevStr.append("c" 重复 2 次)` $\to$ 变成了 `"acc"`。


* 最后把这个结果交给 `curStr`，继续往下走。



---

**核心对应关系**

* **`countStack.pop()` 的次数**：管的是**当前房间里**刚刚收集完的 `curStr`。
* **`strStack.pop()` 的前缀**：是这个房间**左边门外**的原有字符串，用来被当前成果拼接上去的。

所以数字正好乘在“本次”括号里收集到的字符串上，前缀也正好接在最前面，两者严丝合缝，没有错位。
 * 
 */


class Solution {
    public String decodeString(String s) {
        //双栈做法，理清思路：

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()){
            //如果是数字，注意连续数字
            if(Character.isDigit(c)){
                k = k*10 + (c - '0');
            }else if( c == '['){
                //如果是左括号，代表进入房间之前，需要将之前的数字和字符都存起来先
                countStack.push(k);
                k = 0;
                strStack.push(curStr);
                curStr = new StringBuilder();

            }else if(c == ']'){
                //如果遇到右括号，证明这一层结束了，需要将他的次数+前缀拿出来，拼接
                int cnt = countStack.pop();
                StringBuilder preStr = strStack.pop();
                for(int i =0;i<cnt;i++){
                    preStr.append(curStr);
                }
                //拼接完以后别忘记更新curstr
                curStr = preStr;
            }else{
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
