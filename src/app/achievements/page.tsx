import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import AchievementCard from "./AchievementCard";

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex ">
      <Sidebar />
      <div className="pt-36 px-24 w-full">
        <div className="flex space-x-4">
          <div className="text-2xl font-normal">
            Achievements
            <span className="font-semibold text-3xl uppercase">
              {props.params.id}
            </span>
          </div>
          <AvatarImage />
        </div>
        <div className="grid grid-cols-3 mt-24 gap-8 w-full">
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
        </div>
      </div>
    </div>
  );
}
