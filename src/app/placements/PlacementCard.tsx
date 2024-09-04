export default function PlacementCard(props: {
  eventName: String;
  location: String;
  placed: number;
  avgLpa: number;
  url: string;
}) {
  return (
    <div className="flex flex-col items-start p-8 justify-between rounded-2xl border border-neutral-200 h-fit">
      <img
        src={props.url}
        alt={`${props.eventName}`}
        className="w-auto h-80 object-cover"
      />

      <div className="flex justify-between items-center">
        <div>
          <p className="text-base font-bold ">{props.eventName}</p>
          <p className="text-sm">{props.location}</p>
        </div>
      </div>
      <div className="flex justify-between items-center">
        <div className="flex flex-col space-y-2">
          <p className=" font-semibold">Placed</p>
          <p className="font-medium text-gray-500">Avg.LPA</p>
        </div>
        <div className="flex flex-col space-y-2">
          <p className=" font-semibold">{props.placed}</p>
          <p className="font-medium">{props.avgLpa}</p>
        </div>
      </div>    
    </div>
  );
}
