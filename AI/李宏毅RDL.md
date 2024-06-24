# 基本概念

[思维导图](https://www.yuque.com/jupiter-obnuy/gpl12l/dtzg0takkm2emqnm)

# 公式

## Trajectory
$\tau = \{s_1, a_1, s_2, a_2, \cdots, s_T, a_T\}$
$\begin{align*}
p_{\theta}(\tau) &= p(s_1) p_{\theta}(a_1 \mid s_1) p(s_2 \mid s_1, a_1) p_{\theta}(a_2 \mid s_2) p(s_3 \mid s_2, a_2) \cdots \\
&= p(s_1) \prod_{t=1}^{T} p_{\theta}(a_t \mid s_t) p(s_{t+1} \mid s_t, a_t)
\end{align*}$
## Expected Reward
$R(\tau) = \sum_{t=1}^{T} r_t$
$\overline{R}_{\theta} = \sum_{\tau} R(\tau) p_{\theta}(\tau) = \mathbb{E}_{\tau \sim p_{\theta}(\tau)} [R(\tau)]$
## Policy Gradient
$$
\begin{align*}
\nabla \overline{R}_{\theta} &= \sum_{\tau} R(\tau) \nabla p_{\theta}(\tau) = \sum_{\tau} R(\tau) p_{\theta}(\tau) \frac{\nabla p_{\theta}(\tau)}{p_{\theta}(\tau)} \\
R(\tau) &\text{ do not have to be differentiable} \\
&\text{It can even be a black box.} \\
&= \sum_{\tau} R(\tau) p_{\theta}(\tau) \nabla \log p_{\theta}(\tau) \\

&=\mathbb{E}_{\tau \sim p_{\theta}(\tau)} [R(\tau) \nabla \log p_{\theta}(\tau)] \approx \frac{1}{N} \sum_{n=1}^{N} R(\tau^n) \nabla \log p_{\theta}(\tau^n) \\
&= \frac{1}{N} \sum_{n=1}^{N} \sum_{t=1}^{T_n} R(\tau^n) \nabla \log p_{\theta}(a_t^n | s_t^n)
\end{align*}$
$$





---

$$\begin{align*}
\theta &\leftarrow \theta + \eta \nabla \overline{R}_{\theta} \\
\nabla \overline{R}_{\theta} &= \frac{1}{N} \sum_{n=1}^{N} \sum_{t=1}^{T_n} R(\tau^n) \nabla \log p_{\theta} (a_t^n | s_t^n)
\end{align*}$$

---

$\nabla \bar{R}_{\theta} \approx \frac{1}{N} \sum_{n=1}^{N} \sum_{t=1}^{T_n} \left( \sum_{t'=t}^{T_n} \gamma^{t'-t} r_{t'}^n - b \right) \nabla \log p_{\theta}(a_t^n | s_t^n)$
## Advantage Function
$A^{\theta}(s_t, a_t)=\sum_{t'=t}^{T_n} \gamma^{t'-t} r_{t'}^n - b$
## PPO
### Importance Sampling
$\begin{align*}
E_{x \sim p}[f(x)] & \approx \cancel{\frac{1}{N} \sum_{i=1}^{N} f(x_i)} \\
&= \int f(x) p(x) dx \\
&= \int f(x) \frac{p(x)}{q(x)} q(x) dx \\
&= E_{x \sim q} \left[ f(x) \frac{p(x)}{q(x)} \right]\
\end{align*}$

### Off-Policy
$$
\begin{align*}
\nabla \bar{R}_{\theta} &= \mathbb{E}_{\tau \sim p_{\theta}(\tau)} \left[ R(\tau) \nabla \log p_{\theta}(\tau) \right] \\

 \nabla \bar{R}_{\theta} &= \mathbb{E}_{\tau \sim p_{\theta'}(\tau)} \left[ \frac{p_{\theta}(\tau)}{p_{\theta'}(\tau)} R(\tau) \nabla \log p_{\theta}(\tau) \right] \\
&= \mathbb{E}_{(s_t, a_t) \sim \pi_{\theta}} \left[ A^{\theta}(s_t, a_t) \nabla \log p_{\theta}(a_t | s_t^n) \right] \\
&= \mathbb{E}_{(s_t, a_t) \sim \pi_{\theta'}} \left[ \frac{P_{\theta}(s_t, a_t)}{P_{\theta'}(s_t, a_t)} A^{\theta'}(s_t, a_t) \nabla \log p_{\theta}(a_t | s_t^n) \right] \\
&= \mathbb{E}_{(s_t, a_t) \sim \pi_{\theta'}} \left[ \frac{p_{\theta}(a_t | s_t)}{p_{\theta'}(a_t | s_t)} \frac{p_{\theta}(s_t)}{p_{\theta'}(s_t)} A^{\theta'}(s_t, a_t) \nabla \log p_{\theta}(a_t | s_t^n) \right] \\
J^{\theta'}(\theta) &= \mathbb{E}_{(s_t, a_t) \sim \pi_{\theta'}} \left[ \frac{p_{\theta}(a_t | s_t)}{p_{\theta'}(a_t | s_t)} A^{\theta'}(s_t, a_t) \right] 

\end{align*}
$$

### PPO
$J_{PPO}^{\theta'}(\theta) = J^{\theta'}(\theta) - \beta KL(\theta, \theta')$、
动态调整$\beta$:

- 如果当前策略$\theta$与旧策略$\theta^k$之间的KL散度 $KL(\theta, \theta^k)$ 超过了预设的最大值$KL_{max}$ ，则增加$\beta$。这意味着策略更新幅度过大，需要增加$\beta$来更严格地限制策略更新。
- 如果当前策略(\theta)与旧策略(\theta^k)之间的KL散度 $KL(\theta, \theta^k)$ 低于预设的最小值 $KL_{min}$，则减少$\beta$。这意味着策略更新幅度过小，可以减少$\beta$来允许更大的策略更新。
### PPO2
$J_{PPO2}^{\theta^k}(\theta) \approx \sum_{(s_t, a_t)} \min \left( \frac{p_{\theta}(a_t | s_t)}{p_{\theta^k}(a_t | s_t)} A^{\theta^k}(s_t, a_t), \, \text{clip} \left( \frac{p_{\theta}(a_t | s_t)}{p_{\theta^k}(a_t | s_t)}, 1 - \epsilon, 1 + \epsilon \right) A^{\theta^k}(s_t, a_t) \right)$

如果 A>0，我们希望$p_{\theta}(a_t | s_t)$越大越好，但是如果$p_{\theta}(a_t | s_t), p_{\theta^k}(a_t | s_t)$这两项差距过大影响 Important Sampling 的最终的结论，又因为$p_{\theta^k}(a_t | s_t)$是确定的，多次梯度下降完成后的参数$p_{\theta}(a_t | s_t)$过大会影响结论，因此需要给到 一个$\frac{p_{\theta}(a_t | s_t)}{p_{\theta^k}(a_t | s_t)}$的最大值以限制$p_{\theta}(a_t | s_t)$一直更新更新得太大导致与$p_{\theta^k}(a_t | s_t)$相差太多。反之亦然。
## Actor Critic
$$
\begin{aligned}
V^{\theta}\left(S_{t}\right) &=r_{t}+\gamma r_{t+1}+\gamma^{2} r_{t+2} ... \\
V^{\theta}\left(S_{t+1}\right) &=r_{t+1}+\gamma r_{t+2}+... \\
V^{\theta}\left(S_{t}\right) &=\gamma V^{\theta}\left(S_{t+1}\right)+r_{t} \\
r_{t} &= V^{\theta}\left(S_{t}\right)-\gamma V^{\theta}\left(S_{t+1}\right) \\

\end{aligned}
$$


$￥A_{t} = G_{t}' - V^{\theta}(S_{t}) = r_{t} + V^{\theta}(S_{t+1}) - V^{\theta}(S_{t})$

$G_{t}'$ 是指在时间步 $t$ 时刻的 **回报** (Return) 的估计值。 和 $V^{\theta}(S_{t})$ (状态价值函数)不同，$G_{t}'$ 通常是基于当前策略，从时间步 $t$ 到游戏结束或情节结束时所有奖励的总和。 你可以将 $G_{t}'$ 理解为一种对未来收益的预测，它在时间步 $t$ 时刻对 "从现在开始，我能获得多少奖励" 做出估计。



